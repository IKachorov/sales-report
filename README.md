# sales-report

#Design and implement a REST API around the daily report homework.

#You'll need to handle 3 operations:

1. Register a purchase (City, Store, Purchase Id, Amount)

2. Generate stores report - return JSON report with the following format:

[
  {
    "store": "Store 1, Sofia",
    "numberOfPurchases": 12,
    "totalAmount": 600,
    "avgAmount": 50.41
  },
  ...
]
#3. Generate cities report - return JSON report with the following format:

[
  {
    "city": "Sofia",
    "numberOfPurchases": 12,
    "totalAmount": 600,
    "avgAmount": 50.41
  },
  ...
]
