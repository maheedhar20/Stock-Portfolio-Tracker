import axios from "axios";

const API_KEY = "GZEBRCX2IUYFK2MA";
const BASE_URL = "https://www.alphavantage.co/query";

export const fetchStockPrice = async (ticker) => {
  const response = await axios.get(`${BASE_URL}?function=GLOBAL_QUOTE&symbol=${ticker}&apikey=${API_KEY}`);
  const price = response.data["Global Quote"]["05. price"];
  return parseFloat(price);
};

