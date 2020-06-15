# barcode-generator
Serviço para gerar um código de barras

## Build 
```console
./gradlew clean build
```
## Execução 
```console
java -jar barcode-generator-0.0.1-SNAPSHOT.jar
```

## Request
```console
curl --location --request GET 'http://localhost:8080/generate-barcode/123456'
```

## Response
```json
{
    "value": "123456",
    "base64": "iVBORw0KGgoAAAANSUhEUgAAAIAAAABpAQAAAADaDhYsAAAACXBIWXMAABcSAAAXEgFnn9JSAAAAEnRFWHRTb2Z0d2FyZQBCYXJjb2RlNEryjnYuAAAAoUlEQVR42mMocRUPdA8UvBoTKC66uGuXEsOowKjAqMCowKjAkBb4jwaIFDj+4B/7nwr5h3AB9gM1zECBA3AB9Xu2H39U/u+DCzz/b//zU+V/eWSBj98q7O0RAv/smd9VyCsiCdQzn6vuZ0AI/Pn/8V79eZl6uMDP/z8b5M/bIQQ+ows8//vxX3n/HLgAwwEb5n8F8g3/EQJ27P8q7B9i9S0AqSHIjluhoPcAAAAASUVORK5CYII="
}
```
