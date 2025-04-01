import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';
import 'package:fl_chart/fl_chart.dart';

class StockChart extends StatefulWidget {
  @override
  _StockChartState createState() => _StockChartState();
}

class _StockChartState extends State<StockChart> {
  final String apiKey = "04LEG2D5LGVJQBSL";
  String selectedSymbol = "";
  String selectedFunction = "";
  List<FlSpot> stockData = [];
  bool isLoading = false;

  List<String> stockSymbols = [
    "AAPL", "GOOGL", "MSFT", "TSLA", "AMZN", 
    "IBM", "NFLX", "FB", "NVDA", "BABA"
  ];

  List<Map<String, String>> timeSeriesFunctions = [
    {"name": "Intraday", "value": "TIME_SERIES_INTRADAY"},
    {"name": "Daily", "value": "TIME_SERIES_DAILY"},
    {"name": "Weekly", "value": "TIME_SERIES_WEEKLY"},
    {"name": "Monthly", "value": "TIME_SERIES_MONTHLY"},
    {"name": "Monthly Adj", "value": "TIME_SERIES_MONTHLY_ADJUSTED"},
    {"name": "Quote", "value": "GLOBAL_QUOTE"},
  ];

  Future<void> fetchStockData() async {
    if (selectedSymbol.isEmpty || selectedFunction.isEmpty) {
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(content: Text("Please select both Symbol and Functionality")),
      );
      return;
    }
    
    setState(() {
      isLoading = true;
      stockData = [];
    });

    final url = Uri.parse('https://www.alphavantage.co/query?function=$selectedFunction&symbol=$selectedSymbol&apikey=$apiKey');
    final response = await http.get(url);

    if (response.statusCode == 200) {
      final Map<String, dynamic> data = json.decode(response.body);
      String timeSeriesKey = data.keys.firstWhere((key) => key.contains("Time Series"), orElse: () => "");
      
      if (timeSeriesKey.isNotEmpty) {
        final timeSeries = data[timeSeriesKey];
        List<FlSpot> tempData = [];
        int index = 0;

        timeSeries.forEach((time, values) {
          double price = double.parse(values['1. open']);
          tempData.add(FlSpot(index.toDouble(), price));
          index++;
        });

        setState(() {
          stockData = tempData.reversed.toList();
        });
      }
    }
    setState(() {
      isLoading = false;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text("Stock Market Chart")),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text("Select the Symbol", style: TextStyle(fontSize: 16, fontWeight: FontWeight.bold)),
            DropdownButton<String>(
              isExpanded: true,
              hint: Text("Select Symbol"),
              value: selectedSymbol.isEmpty ? null : selectedSymbol,
              onChanged: (value) {
                setState(() {
                  selectedSymbol = value!;
                });
              },
              items: stockSymbols.map((symbol) {
                return DropdownMenuItem(
                  value: symbol,
                  child: Text(symbol),
                );
              }).toList(),
            ),
            SizedBox(height: 20),
            Text("Select the Functionality", style: TextStyle(fontSize: 16, fontWeight: FontWeight.bold)),
            DropdownButton<String>(
              isExpanded: true,
              hint: Text("Select Function"),
              value: selectedFunction.isEmpty ? null : selectedFunction,
              onChanged: (value) {
                setState(() {
                  selectedFunction = value!;
                });
              },
              items: timeSeriesFunctions.map((func) {
                return DropdownMenuItem(
                  value: func['value'],
                  child: Text(func['name']!),
                );
              }).toList(),
            ),
            SizedBox(height: 20),
            Center(
              child: ElevatedButton(
                onPressed: fetchStockData,
                child: const Text("View Stats"),
              ),
            ),
            SizedBox(height: 20),
            Expanded(
              child: Container(
                decoration: BoxDecoration(
                  border: Border.all(color: Colors.black),
                  borderRadius: BorderRadius.circular(10),
                ),
                padding: EdgeInsets.all(10),
                child: isLoading
                    ? const Center(child: CircularProgressIndicator())
                    : stockData.isEmpty
                        ? const Center(child: Text("Select a stock and function"))
                        : Column(
                            children: [
                              Align(
                                alignment: Alignment.centerLeft,
                                child: Text("Y-Axis: Stock Price (${selectedFunction.replaceAll('_', ' ')})", style: TextStyle(fontWeight: FontWeight.bold)),
                              ),
                              Expanded(
                                child: LineChart(
                                  LineChartData(
                                    gridData: FlGridData(show: true),
                                    titlesData: FlTitlesData(
                                      leftTitles: AxisTitles(
                                        sideTitles: SideTitles(showTitles: true, reservedSize: 40),
                                      ),
                                      bottomTitles: AxisTitles(
                                        sideTitles: SideTitles(showTitles: true, reservedSize: 40),
                                      ),
                                    ),
                                    borderData: FlBorderData(show: true),
                                    lineBarsData: [
                                      LineChartBarData(
                                        spots: stockData,
                                        isCurved: true,
                                        color: Colors.blue,
                                        barWidth: 2,
                                        isStrokeCapRound: true,
                                        belowBarData: BarAreaData(show: false),
                                      ),
                                    ],
                                  ),
                                ),
                              ),
                              Align(
                                alignment: Alignment.center,
                                child: Text("X-Axis: Time", style: TextStyle(fontWeight: FontWeight.bold)),
                              ),
                            ],
                          ),
              ),
            ),
          ],
        ),
      ),
    );
  }
}