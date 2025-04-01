import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';

class StockSearch extends StatefulWidget {
  @override
  _StockSearchState createState() => _StockSearchState();
}

class _StockSearchState extends State<StockSearch> {
  final String apiKey = "afd9d2859780483bb2e561bf61a57f8f";
  TextEditingController _controller = TextEditingController();
  List<Map<String, dynamic>> stockResults = [];
  bool isLoading = false;

  Future<void> searchStock(String query) async {
    if (query.isEmpty) return;
    setState(() {
      isLoading = true;
      stockResults = [];
    });

    final url = Uri.parse('https://api.twelvedata.com/symbol_search?symbol=$query&apikey=$apiKey');
    final response = await http.get(url);

    if (response.statusCode == 200) {
      final Map<String, dynamic> data = json.decode(response.body);
      if (data.containsKey("data")) {
        setState(() {
          stockResults = List<Map<String, dynamic>>.from(data["data"]);
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
      appBar: AppBar(title: Text("Stock Search")),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          children: [
            TextField(
              controller: _controller,
              decoration: InputDecoration(
                labelText: "Enter stock symbol",
                suffixIcon: IconButton(
                  icon: Icon(Icons.search),
                  onPressed: () => searchStock(_controller.text),
                ),
              ),
            ),
            SizedBox(height: 20),
            isLoading
                ? Center(child: CircularProgressIndicator())
                : Expanded(
                    child: ListView.builder(
                      itemCount: stockResults.length,
                      itemBuilder: (context, index) {
                        final stock = stockResults[index];
                        return Card(
                          child: ListTile(
                            title: Text(stock["instrument_name"] ?? "Unknown"),
                            subtitle: Column(
                              crossAxisAlignment: CrossAxisAlignment.start,
                              children: [
                                Text("Symbol: ${stock["symbol"]}"),
                                Text("Exchange: ${stock["exchange"]}"),
                                Text("Country: ${stock["country"]}"),
                                Text("Currency: ${stock["currency"]}"),
                              ],
                            ),
                          ),
                        );
                      },
                    ),
                  ),
          ],
        ),
      ),
    );
  }
}
