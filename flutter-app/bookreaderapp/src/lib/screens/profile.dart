import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';

class ProfilePage extends StatefulWidget {
  const ProfilePage({super.key});

  @override
  _ProfilePageState createState() => _ProfilePageState();
}

class _ProfilePageState extends State<ProfilePage> {
  final String apiKey = "afd9d2859780483bb2e561bf61a57f8f";
  List<String> stockSymbols = [
    "AAPL", "GOOGL", "MSFT", "TSLA", "AMZN", "NVDA", "FB", "NFLX", "BABA", "V",
    "PYPL", "INTC", "CSCO", "ADBE", "PEP", "KO", "NKE", "MRNA", "IBM", "WMT",
    "ORCL", "CRM", "DIS", "XOM", "PFE", "T", "GE", "BA", "MCD", "QCOM"
  ];
  String selectedSymbol = "AAPL";
  Map<String, dynamic>? profileData;
  String? logoUrl;

  @override
  void initState() {
    super.initState();
    fetchProfile(selectedSymbol);
  }

  Future<void> fetchProfile(String symbol) async {
    final profileUrl = "https://api.twelvedata.com/profile?symbol=$symbol&apikey=$apiKey";
    final logoUrlApi = "https://api.twelvedata.com/logo?symbol=$symbol&apikey=$apiKey";
    
    final profileResponse = await http.get(Uri.parse(profileUrl));
    final logoResponse = await http.get(Uri.parse(logoUrlApi));
    
    if (profileResponse.statusCode == 200 && logoResponse.statusCode == 200) {
      setState(() {
        profileData = json.decode(profileResponse.body);
        logoUrl = json.decode(logoResponse.body)["url"];
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text("Profile View")),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Row(
              children: [
                Expanded(
                  child: DropdownButton<String>(
                    value: selectedSymbol,
                    items: stockSymbols.map((String symbol) {
                      return DropdownMenuItem<String>(
                        value: symbol,
                        child: Text(symbol),
                      );
                    }).toList(),
                    onChanged: (String? newValue) {
                      if (newValue != null) {
                        setState(() {
                          selectedSymbol = newValue;
                        });
                      }
                    },
                  ),
                ),
                ElevatedButton(
                  onPressed: () => fetchProfile(selectedSymbol),
                  child: const Text("View Profile"),
                ),
              ],
            ),
            const SizedBox(height: 20),
            if (logoUrl != null)
              Center(
                child: Image.network(logoUrl!, height: 100, width: 100, fit: BoxFit.contain),
              ),
            const SizedBox(height: 10),
            Expanded(
              child: SingleChildScrollView(
                child: profileData != null
                    ? Table(
                        border: TableBorder.all(),
                        columnWidths: const {0: FractionColumnWidth(0.3), 1: FractionColumnWidth(0.7)},
                        children: profileData!.entries.map((entry) {
                          return TableRow(
                            children: [
                              Padding(
                                padding: const EdgeInsets.all(8.0),
                                child: Text(entry.key, style: const TextStyle(fontWeight: FontWeight.bold)),
                              ),
                              Padding(
                                padding: const EdgeInsets.all(8.0),
                                child: Text(entry.value.toString()),
                              ),
                            ],
                          );
                        }).toList(),
                      )
                    : const Center(child: CircularProgressIndicator()),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
