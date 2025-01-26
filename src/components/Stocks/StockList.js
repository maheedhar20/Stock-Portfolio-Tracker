import React from "react";

const StockList = ({ stocks, deleteStock }) => {
  return (
    <div>
      <h2>Stock Holdings</h2>
      <table>
        <thead>
          <tr>
            <th>Name</th>
            <th>Ticker</th>
            <th>Quantity</th>
            <th>Buy Price</th>
            <th>Current Price</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {stocks.map((stock, index) => (
            <tr key={index}>
              <td>{stock.name}</td>
              <td>{stock.ticker}</td>
              <td>{stock.quantity}</td>
              <td>${stock.buyPrice.toFixed(2)}</td>
              <td>${stock.currentPrice.toFixed(2)}</td>
              <td>
                <button onClick={() => deleteStock(index)}>Delete</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default StockList;
