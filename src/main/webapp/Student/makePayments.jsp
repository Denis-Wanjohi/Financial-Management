<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Payment Form</title>
    <style>
      body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f7fafc;
      }
      a {
        text-decoration: none;
      }

      li {
        list-style: none;
      }

      /* NAVBAR STYLING STARTS */
      .navbar {
        display: flex;
        align-items: center;
        justify-content: space-between;
        padding: 20px;
        background-color: teal;
        color: #fff;
      }

      .nav-links a {
        color: #fff;
      }

      /* LOGO */
      .logo {
        font-size: 32px;
      }

      /* NAVBAR MENU */
      .nav-links {
        display: flex;
        gap: 1em;
        font-size: 18px;
      }

      .nav-links li:hover {
        background-color: #4c9e9e;
        border-radius: 5px;
        transition: 0.3s ease;
      }

      .nav-links li {
        padding: 5px 14px;
      }

      #container {
        width: 80%;
        margin: 50px auto;
        background-color: #fff;
        border-radius: 10px;
        box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
        padding: 30px;
      }

      #container form {
        margin: auto;
        width: 100%;
      }

      #container fieldset {
        border: none;
        padding: 0;
        margin: 0;
      }
      #bank {
        padding: 10px;
        width: 72%;
        border-radius: 5px;
        border: 1px solid #91b2dd;
      }
      #container label {
        display: block;
        font-weight: bold;
        width: 25%;
        text-align: left;
        padding-right: 10px;
        color: #59729b;
        margin-bottom: 10px;
      }

      #container input[type="text"] {
        width: 70%;
        padding: 10px;
        border: 1px solid #91b2dd;
        border-radius: 5px;
        transition: border-color 0.3s ease;
        font-size: 16px;
        outline: none;
        float: left;
        margin-bottom: 10px;
      }

      #container input[type="text"]:focus {
        border-color: #4fc3f7;
      }

      #submit {
        margin: 30px auto;
        text-align: center;
      }

      #submit button {
        background-color: #4a5568;
        color: #fff;
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-size: 16px;
        transition: background-color 0.3s ease;
      }

      #submit button:hover {
        background-color: #1a365d;
      }
    </style>
  </head>
  <body>
    <nav class="navbar">
      <div class="logo">PAYMENTS</div>

      <ul class="nav-links">
        <li><a href="/Final/Student/Home">Home</a></li>
      </ul>
    </nav>
    <div id="container">
      <form action="/Final/payments" method="post">
        <fieldset>
          <label for="registration_number">Registration No:</label>
          <input
            type="text"
            id="registration_number"
            required
            name="registration_number"
          />

          <label for="bank">BANK:</label>
          <select id="bank" name="bank">
            <option value="Kenya Commercial Bank Ltd">
              Kenya Commercial Bank Ltd
            </option>
            <option value="Co-operative Bank of Kenya Ltd">
              Co-operative Bank of Kenya Ltd
            </option>
            <option value="Standard Chartered Bank (K) Ltd">
              Standard Chartered Bank (K) Ltd
            </option>
          </select>
          <br />

          <label for="account_number">Account No.:</label>
          <input
            type="text"
            id="account_number"
            required
            name="account_number"
          />

          <label for="amount">Amount:</label>
          <input type="text" id="amount" required name="amount" />
          <br />
          <label for="transactionCode">Transaction code:</label>
          <input
            type="text"
            id="transactionCode"
            required
            name="transaction_code"
          />
          <br />
          <p><%=request.getAttribute("error") %></p>
        </fieldset>
        <div id="submit">
          <button type="submit">COMPLETE PAYMENT</button>
        </div>
      </form>
    </div>
  </body>
</html>
