# net-prcie-calculator

## Description
net-prcie-calculator is a service  allows consumers to calculate the net price from a gross price.
The service is built with Spring Boot and exposed as a rest service through following endpoints:
http://localhost:8080/api/net_price?country={COUNTRY}&price={PRICE}

Moreover, a tiny fontend application (React app built in within the artifact) as a demo:
http://localhost:8080/

## installation and running the app
To install and run use the following commands from root directory

```bash
$ mvn install
$ docker build -t net-price-calculator .
$ docker run -dp 8080:8080 net-price-calculator
## ENDPOINTS:
client demo ==> http://localhost:8080/
sevice endpint ==> http://localhost:8080/api/net_price?country={COUNTRY}&price={PRICE}


## stay in touch
- Author - [Abubaker Enayet](abubaker.enayet@gmail.com)
- LinkedIn - (https://www.linkedin.com/in/abubaker-enayet-b1385276)

