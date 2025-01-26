import React, { useState } from "react";
import { Pie } from "react-chartjs-2";
import StockForm from "./Stocks/StockForm";
import StockList from "./Stocks/StockList";
import { fetchStockPrice } from "../services/stockService";
import {
  Chart as ChartJS,
  ArcElement,
  Tooltip,
  Legend
} from "chart.js";

ChartJS.register(ArcElement, Tooltip, Legend);

const Dashboard = ({ logout }) => {
  const [stocks, setStocks] = useState([]);

  const addStock = async (stock) => {
    try {
      const currentPrice = await fetchStockPrice(stock.ticker);
      setStocks([...stocks, { ...stock, currentPrice }]);
    } catch (error) {
      alert("Error fetching stock price. Please check the ticker.");
    }
  };

  const deleteStock = (index) => {
    setStocks(stocks.filter((_, i) => i !== index));
  };

  const totalValue = stocks.reduce(
    (acc, stock) => acc + stock.currentPrice * stock.quantity,
    0
  );

  const data = {
    labels: stocks.map((stock) => stock.name),
    datasets: [
      {
        data: stocks.map((stock) => stock.currentPrice * stock.quantity),
        backgroundColor: ["#FF6384", "#36A2EB", "#FFCE56", "#4BC0C0", "#9966FF"],
      },
    ],
  };

  const options = {
    responsive: true,
    maintainAspectRatio: false,
  };
  
  return (
    <div>
      <h1>Portfolio Dashboard</h1>
      <button onClick={logout}>Logout</button>
      <div style={{ display: "flex", justifyContent: "space-between" }}>
        {/* Pie Chart */}
        <div style={{ height: "400px", width: "400px" }}>
          <h2>Portfolio Distribution</h2>
          <p>Total Portfolio Value: ${totalValue.toFixed(2)}</p>
          <Pie data={data} options={options} />
        </div>

        {/* Stock Form */}
        <div style={{ marginLeft: "20px", flex: 1 }}>
          <h2>Add Stock</h2>
          <StockForm addStock={addStock} />
        </div>
      </div>

      {/* Stock List */}
      <div>
        <h2>Stock Holdings</h2>
        <StockList stocks={stocks} deleteStock={deleteStock} />
      </div>
    </div>
  );
};  

export default Dashboard;
