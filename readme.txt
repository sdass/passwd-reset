https://www.codebyamir.com/blog/forgot-password-feature-with-java-and-spring-boot

To passwd-reset
step 1: C:\Temp\Pair1>curl -X POST "http://localhost:8086/passwd-reset/forgotrest2?email=sdass@demo.com"

works: result
in processAndSendForgotPasswordURLrest2()...
tokenUrl=http://localhost/passwd-reset/reset?token=05e9df35-7127-4e22-89bc-

c37abb0422e7< model.success=password reset link sent to your email
2018-07-13 16:28:04.726

step 2: curl "http://localhost/passwd-reset/reset?token=05e9df35-7127-4e22-89bc-

c37abb0422e7"
change port to 8086

correct so far
------