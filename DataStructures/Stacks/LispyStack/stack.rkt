#lang racket

(define stack%
  
  (class object%

    (init [stack-list '()])

    (define head '())

    (super-new)

    (define/public (push el)
      (let ([top (mcons el '())])
        (if (null? head)
            (set! head top)
            (begin
              (set-mcdr! top head)
              (set! head top)))))

    (define/public (pop)
      (if (null? head) (error "Stack is empty")
          (let ([top (mcar head)])
            (set! head (mcdr head))
            top)))

    (define/public (print)
      (define (prt rest)
        (if (null? rest)
            (newline)
            (let ([top (mcar rest)])
              (printf "~a " top)
              (prt (mcdr rest)))))
      (prt head))

    (for ([i stack-list]) (push i))))

