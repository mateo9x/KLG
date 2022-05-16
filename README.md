Swagger:

http://localhost:8080/swagger-ui.html

Przykładowy JSON dla POST/PUT:

{
"fromDate": "2022-05-10T19:47:52.703Z",
"toDate": "2022-05-10T19:47:52.703Z",
"rentObject": {
"capacity": 500,
"description": "Testowy opis",
"id": 1,
"name": "Pierwszy obiekt",
"unitPrice": 50
},
"tenant": {
"id": 1,
"name": "Pierwszy-wynajmujacy"
}
}

Przykładowe curl-e GET-a:

curl --request GET localhost:8080/reservations/rent-object/2

curl --request GET localhost:8080/reservations/tenant/Pierwszy-wynajmujacy

curl "http://localhost:8080/reservations" ^
-H "Accept-Language: pl,en;q=0.9" ^
-H "Connection: keep-alive" ^
-H "Content-Type: application/json" ^
-H "DNT: 1" ^
-H "Origin: http://localhost:8080" ^
-H "Referer: http://localhost:8080/swagger-ui.html" ^
-H "Sec-Fetch-Dest: empty" ^
-H "Sec-Fetch-Mode: cors" ^
-H "Sec-Fetch-Site: same-origin" ^
-H "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/101.0.4951.54 Safari/537.36" ^
-H "accept: */*" ^
-H "sec-ch-ua: ^\^" Not A;Brand^\^";v=^\^"99^\^", ^\^"Chromium^\^";v=^\^"101^\^", ^\^"Google Chrome^\^";v=^\^"101^\^"" ^
-H "sec-ch-ua-mobile: ?0" ^
-H "sec-ch-ua-platform: ^\^"Windows^\^"" ^
--data-raw ^"^{^

^\^"fromDate^\^": ^\^"2022-05-10T19:47:52.703Z^\^",^

^\^"toDate^\^": ^\^"2022-05-10T19:47:52.703Z^\^",^

^\^"rentObject^\^": ^{^

    ^\^"capacity^\^": 500,^

    ^\^"description^\^": ^\^"Testowy opis^\^",^

    ^\^"id^\^": 1,^

    ^\^"name^\^": ^\^"Pierwszy obiekt^\^",^

    ^\^"unitPrice^\^": 50^

^},^

^\^"tenant^\^": ^{^

    ^\^"id^\^": 1,^

    ^\^"name^\^": ^\^"Pierwszy-wynajmujacy^\^"^

^}^

^}^" ^
--compressed

