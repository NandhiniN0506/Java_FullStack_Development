import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';
import 'package:fl_chart/fl_chart.dart';

class TimeSeriesGraph extends StatefulWidget {
  const TimeSeriesGraph({super.key});

  @override
  _TimeSeriesGraphState createState() => _TimeSeriesGraphState();
}

class _TimeSeriesGraphState extends State<TimeSeriesGraph> {
  final String apiKey = "afd9d2859780483bb2e561bf61a57f8f";
  String selectedSymbol = "AAPL";
  String selectedInterval = "1min";
  String selectedType = "Common Stock";
  List<String> stockSymbols = [
    "AAPL", "GOOGL", "MSFT", "TSLA", "AMZN", "NFLX", "NVDA", "META", "AMD", "BABA",
    "IBM", "ORCL", "PYPL", "ADBE", "INTC", "CRM", "CSCO", "PEP", "KO", "MCD"
  ];
  List<String> intervals = ["1min", "5min", "15min", "30min", "45min", "1h", "2h", "4h", "1day", "1week", "1month"];
  List<String> assetTypes = ["Common Stock", "ETF", "Bond", "Mutual Fund", "Digital Currency", "REIT"];
  List<FlSpot> chartData = [];

  Future<void> fetchTimeSeries() async {
    final String url = "https://api.twelvedata.com/time_series?symbol=$selectedSymbol&interval=$selectedInterval&type=$selectedType&apikey=$apiKey";
    final response = await http.get(Uri.parse(url));

    if (response.statusCode == 200) {
      Map<String, dynamic> data = json.decode(response.body);
      if (data["values"] != null) {
        List<dynamic> values = data["values"];
        setState(() {
          chartData = values.asMap().entries.map((entry) {
            int index = entry.key;
            double close = double.tryParse(entry.value["close"]) ?? 0.0;
            return FlSpot(index.toDouble(), close);
          }).toList().reversed.toList();
        });
      }
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text("Time Series Graph")),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          children: [
            Container(
              padding: const EdgeInsets.all(12.0),
              decoration: BoxDecoration(
                color: Colors.grey[200],
                borderRadius: BorderRadius.circular(12),
              ),
              child: Column(
                children: [
                  DropdownButton<String>(
                    value: selectedSymbol,
                    items: stockSymbols.map((String symbol) {
                      return DropdownMenuItem(value: symbol, child: Text(symbol));
                    }).toList(),
                    onChanged: (newValue) {
                      setState(() {
                        selectedSymbol = newValue!;
                      });
                    },
                  ),
                  DropdownButton<String>(
                    value: selectedInterval,
                    items: intervals.map((String interval) {
                      return DropdownMenuItem(value: interval, child: Text(interval));
                    }).toList(),
                    onChanged: (newValue) {
                      setState(() {
                        selectedInterval = newValue!;
                      });
                    },
                  ),
                  DropdownButton<String>(
                    value: selectedType,
                    items: assetTypes.map((String type) {
                      return DropdownMenuItem(value: type, child: Text(type));
                    }).toList(),
                    onChanged: (newValue) {
                      setState(() {
                        selectedType = newValue!;
                      });
                    },
                  ),
                  ElevatedButton(
                    onPressed: fetchTimeSeries,
                    child: const Text("View Graph"),
                  ),
                ],
              ),
            ),
            const SizedBox(height: 20),
            Expanded(
              child: chartData.isNotEmpty
                  ? LineChart(
                      LineChartData(
                        gridData: FlGridData(show: false),
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
                            spots: chartData,
                            isCurved: true,
                            color: Colors.blue,
                            dotData: FlDotData(show: false),
                          ),
                        ],
                      ),
                    )
                  : const Center(child: Text("Select options and press View Graph")),
            ),
          ],
        ),
      ),
    );
  }
}
