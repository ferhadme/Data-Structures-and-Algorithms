#lang racket

(require rackunit)

(define (string-ref-as-number str index)
  (string->number (string
                   (string-ref str index))))

(define (check-luhn purported-cc)
  (define cc-length (string-length purported-cc))
  (define parity (remainder cc-length 2))
  
  (define (check sum index)
    (if (= index (- cc-length 1))
        (= (remainder sum 10) 0)
        (let ([digit (string-ref-as-number purported-cc index)])
          (cond [(and (= (remainder index 2) parity)
                      (> (* digit 2) 9))
                 (check (+ sum (- (* digit 2) 9)) (+ index 1))]

                [(= (remainder index 2) parity)
                 (check (+ sum (* digit 2)) (+ index 1))]

                [else
                 (check (+ sum digit) (+ index 1))]))))

  (let ([sum (string-ref-as-number purported-cc (- cc-length 1))])
    (check sum 0)))

(check-equal? (check-luhn "5103071501535807") #t)
(check-equal? (check-luhn "3534932892389328") #f)
