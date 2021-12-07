;; Type: number number -> number
;; Returns: the sum of x and y
(lambda (x y) (+ x y))

;; Type: number number -> number
;; Returns: the sum of x and y
((lambda (x y) (+ x y)) 5 6) ; Returns 11
; Different lambda expression since they are anonymous functions!
; Alternative: Storing the lambda expression as constant, not a function!

;; Type: number number -> number
;; Returns: the sum of x and y
(define fct (lambda (x y) (+ x y)))
(fct 5 6) ; Returns 11
