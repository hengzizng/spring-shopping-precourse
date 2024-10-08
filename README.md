# spring-shopping-precourse

## 사용자 스토리

→ 누가, 무엇을, 왜 하는가

- 사용자는 상품을 (상점에) 추가할 수 있다.
- 사용자는 (상점의) 상품을 수정할 수 있다.
- 상품은 잘못된 이름을 가져서는 안 된다.
    → 잘못된 이름이 뭔지 고객과 소통
    - 상품은 최대 최대 15자를 넘는 이름을 가져서는 안 된다.
    - 상품은 일부 특수문자는 허용하지 않는다.
    - 상품은 일부 특수문자는 허용한다.
→ 위 3개까지만 2주 내로, 스토리 분리
- 상품은 비속어를 포함하지 않는다.


```gherkin
Given 상품 이름이 "동해물과 백두산이 마르고 닳도록"일 때
 When 상품을 생성하면
 Then 400 Bad Request를 응답한다.
  And "상품의 이름은 15자를 넘길 수 없습니다."라고 응답한다.
```

```gherkin
Given 기존 상품이 존재할 때
  And 변경하고자 하는 상품 이름이 "동해물과 백두산이 마르고 닳도록"일 때
 When 상품을 수정하면
 Then 400 Bad Request를 응답한다.
  And "상품의 이름은 15자를 넘길 수 없습니다."라고 응답한다.
```

```gherkin
Given 상품 이름이 "아메리카노 *할인"일 때
 When 상품을 생성하면
 Then 400 Bad Request를 응답한다.
  And "상품의 이름에는 ( ), [ ], +, -, &, /, _ 외의 특수문자는 포함될 수 없습니다."라고 응답한다.
```

```gherkin
Given 기존 상품이 존재할 때
  And 변경하고자 하는 상품 이름이 "아메리카노 *할인"일 때
 When 상품을 수정하면
 Then 400 Bad Request를 응답한다.
  And "상품의 이름에는 ( ), [ ], +, -, &, /, _ 외의 특수문자는 포함될 수 없습니다."라고 응답한다.
```

---

상품은 최대 최대 15자를 넘는 이름을 가져서는 안 된다.

공백 포함인지? 케이스를 통해 확인

- [x] 동해물과백두산이마르고닳도록
- [ ] 동해물과 백두산이 마르고 닳도록

상품은 일부 특수문자는 허용하지 않는다.

- [x] (할인) 아메리카노
- [ ] 아메리카노 *할인
- [ ] …

