import 'package:bookreaderapp/screens/time_series.dart';
import 'package:flutter/material.dart';
import 'package:carousel_slider/carousel_slider.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';
import 'stock_chart.dart';
import 'profile.dart';
import 'search.dart';

class StockHomePage extends StatefulWidget {
  const StockHomePage({super.key});

  @override
  _StockHomePageState createState() => _StockHomePageState();
}

class _StockHomePageState extends State<StockHomePage> {
  List<Map<String, String>> stockData = [
    {"symbol": "AAPL", "image": "assets/images/AAPL.png"},
    {"symbol": "GOOGL", "image": "assets/images/GOOGL.png"},
    {"symbol": "AMZN", "image": "assets/images/AMZN.png"},
    {"symbol": "TSLA", "image": "assets/images/TSLA.png"},
    {"symbol": "MSFT", "image": "assets/images/MSFT.png"},
  ];

  List<Map<String, dynamic>> stocks = [];

  @override
  void initState() {
    super.initState();
    fetchStockList();
  }

  Future<void> fetchStockList() async {
    final String url = "https://api.twelvedata.com/stocks";
    final response = await http.get(Uri.parse(url));
    if (response.statusCode == 200) {
      final data = json.decode(response.body);
      setState(() {
        stocks = List<Map<String, dynamic>>.from(data["data"]);
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text("Stock Market Tracker")),
      bottomNavigationBar: BottomNavigationBar(
        items: const [
          BottomNavigationBarItem(icon: Icon(Icons.home, color: Colors.black), label: "Home"),
          BottomNavigationBarItem(icon: Icon(Icons.bar_chart, color: Colors.black), label: "Stats"),
          BottomNavigationBarItem(icon: Icon(Icons.search, color: Colors.black), label: "Search"),
          BottomNavigationBarItem(icon: Icon(Icons.person, color: Colors.black), label: "Profile"),
          BottomNavigationBarItem(icon: Icon(Icons.timelapse, color: Colors.black), label: "Time Series"),
        ],
        onTap: (index) {
          if (index == 0) {
            Navigator.pushReplacement(context, MaterialPageRoute(builder: (context) => const StockHomePage()));
          } else if (index == 1) {
            Navigator.push(context, MaterialPageRoute(builder: (context) => StockChart()));
          } else if (index == 2) {
            Navigator.push(context, MaterialPageRoute(builder: (context) => StockSearch()));
          } else if (index == 3) {
            Navigator.push(context, MaterialPageRoute(builder: (context) => ProfilePage()));
          }
          else if (index == 4) {
            Navigator.push(context, MaterialPageRoute(builder: (context) => const TimeSeriesGraph()));
          }
        },
      ),
      body: SingleChildScrollView(
        child: Padding(
          padding: const EdgeInsets.all(16.0),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              const Text(
                "Trending Stocks",
                style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
              ),
              const SizedBox(height: 10),
              CarouselSlider(
                options: CarouselOptions(
                  height: 200.0,
                  autoPlay: true,
                  enlargeCenterPage: true,
                ),
                items: stockData.map((stock) {
                  return Column(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: [
                      Image.asset(stock["image"]!, height: 100, width: 100, fit: BoxFit.contain),
                      const SizedBox(height: 8),
                      Text(stock["symbol"]!, style: const TextStyle(fontSize: 16, fontWeight: FontWeight.bold)),
                    ],
                  );
                }).toList(),
              ),
              const SizedBox(height: 20),
              const Text(
                "Stock List",
                style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold),
              ),
              const SizedBox(height: 10),
              SizedBox(
                height: 300,
                child: stocks.isNotEmpty
                    ? ListView.builder(
                        itemCount: stocks.length,
                        itemBuilder: (context, index) {
                          return ListTile(
                            title: Text(stocks[index]["name"] ?? "Unknown"),
                            subtitle: Text("Type: ${stocks[index]["type"] ?? "N/A"}"),
                          );
                        },
                      )
                    : const Center(child: CircularProgressIndicator()),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
