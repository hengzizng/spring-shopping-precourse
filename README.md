# spring-shopping-precourse

## 전체 상품 목록 조회
### Request
- http version: HTTP/1.1
- method: GET
- endpoint: /api/products
### Response
- body:
[
  {
  "id": Long,
  "name": String,
  "price": Long,
  "imageUrl": String
  }
]

## 상품 한건 추가
### Request
- http version: HTTP/1.1
- method: POST
- endpoint: /api/products
- body:
{
  "id": Long,
  "name": String,
  "price": Long,
  "imageUrl": String
}

## 상품 한건 수정
### Request
- http version: HTTP/1.1
- method: PUT
- endpoint: /api/products
- body:
  {
  "id": Long,
  "name": String,
  "price": Long,
  "imageUrl": String
  }

## 상품 한건 삭제
### Request
- http version: HTTP/1.1
- method: DELETE
- endpoint: /api/products?id={id}