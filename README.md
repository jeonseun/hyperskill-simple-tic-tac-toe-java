# Simple Tic-Tac-Toe (Java)

hyperskill java project - Simple Tic-Tac-Toe (Java)

## 개요

틱택토 게임, 플레이어 'X', 'O'가 번갈아 필드에 말을 놓으며 먼저 일렬로 3개를 놓는 쪽이 이기는 게임

![gif](./Simple%20Tic-Tac-Toe%20(Java).gif)

게임 규칙

- 3 X 3 필드에서 두 플레이어 'X', 'O'가 진행
- 'X'부터 시작하며 번갈아가며 필드에 말을 놓음
- 한 플레이어가 일렬로 3개(가로, 세로 대각선)를 놓는 순간 해당 플레이어의 승리
- 이미 놓은 자리에는 다시 놓을 수 없음
- 두 플레이어 모두 일렬로 3개를 못 맞춘 상태에서 놓을 자리가 없는 경우 무승부 처리

## 환경

- Java 17
- IntelliJ IDEA 2023.2.3 (Ultimate Edition)

## 배운 것

- 2차원 배열의 사용, 수학 좌표계의 x, y축과 2차원 배열의 x, y축의 차이점 이해
- `Scanner` 를 통한 입력시 타입 불일치로 인한 `InputMismatchException` 예외 처리
- 입력값의 사전 검증
- 논리 연산자 처리 방식(쇼트 서킷)을 이용한 효율적인 처리 