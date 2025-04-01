import 'package:http/http.dart' as http;
import 'dart:convert';

class StockService {
  final String apiKey = "04LEG2D5LGVJQBSL";

  Future<Map<String, dynamic>?> fetchStock(String symbol) async {
    final String url =
        "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=$symbol&apikey=$apiKey";
    final response = await http.get(Uri.parse(url));

    if (response.statusCode == 200) {
      return json.decode(response.body)["Global Quote"];
    } else {
      return null;
    }
  }
}
