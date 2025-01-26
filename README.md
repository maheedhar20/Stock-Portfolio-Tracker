# **Stock Portfolio Tracker**

A web application to help users manage their stock portfolio effectively. Users can add and delete stocks, view current stock prices using the Alpha Vantage API, and analyze their portfolio through a dashboard with interactive graphs. The project is built with **React** for the frontend and **Spring Boot** for the backend.

---

## **Features**
- Add and delete stocks in your portfolio.
- Fetch real-time stock prices using the Alpha Vantage API.
- Visualize stock performance with dynamic graphs on a user dashboard.
- Simple and intuitive user interface for efficient portfolio management.

---

## **Tech Stack**
### **Frontend**: 
- React
- Chart.js (for graph visualizations)
- Axios (for API calls)
- HTML
- CSS

### **Backend**: 
- Spring Boot
- REST APIs

### **API and Database**: 
- MySQL
- Alpha Vantage API for stock data

---

## **Setup Instructions**

### **Prerequisites**
- [Node.js](https://nodejs.org/) and npm installed.
- [Java JDK](https://www.oracle.com/java/technologies/javase-downloads.html) installed (version 11+).
- Maven installed (or use the wrapper provided with Spring Boot).
- [Alpha Vantage API Key](https://www.alphavantage.co/support/#api-key) (Sign up for free).

---

### **1. Frontend Setup**
1. Navigate to the frontend directory:
   ```bash
   cd stock-portfolio-frontend
2. Install dependencies:
   ```bash
   npm install
3. Configure API endpoint:
   - Create a .env file in the frontend folder and add the following:
     ```bash
     REACT_APP_BACKEND_URL=http://localhost:8080
4. Start the frontend:
   ```bash
   npm start
The React app should now be running at http://localhost:3000
   
### **2. Backend Setup**
1. Setup Eclipse IDE or STS to work with spring boot
2. Navigate to the backend directory:
   ```bash
   cd stock-portfolio-backend
3. Build and Run the backend:
   ```bash
   ./mvnw spring-boot:run
   
The backend should be running at http://localhost:8080

## **Running the Full Application:**
- Ensure both the frontend (http://localhost:3000) and backend (http://localhost:8080) are running.
- Access the application through the React frontend.

## **Future Enhancements:**
- Add authentication for user-specific portfolios.
- Enable stock prediction features using machine learning.
- Allow users to set price alerts for stocks.
