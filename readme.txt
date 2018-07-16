https://www.codebyamir.com/blog/forgot-password-feature-with-java-and-spring-boot

h2 console login: http://localhost:8086/passwd-reset/h2-console

To passwd-reset
step 1: C:\Temp\Pair1>curl -X POST "http://localhost:8086/passwd-reset/forgotrest2?email=sdass@demo.com"

works: result
in processAndSendForgotPasswordURLrest2()...
tokenUrl=http://localhost/passwd-reset/reset?token=09eb5d1e-6bd9-427b-a3a0-2250da0adb9c< model.success=password reset link sent to your email
2018-07-13 16:28:04.726

step 2: curl "http://localhost:8086/passwd-reset/reset?token=09eb5d1e-6bd9-427b-a3a0-2250da0adb9c"

C:\Users\sdass\STSworkspace\passwd-reset>curl -X POST "http://localhost:8086/passwd-reset/resetRest2?token=09eb5d1e-6bd9-427b-a3a0-2250da0adb9c&password=newKPasswd45

inputs: token=09eb5d1e-6bd9-427b-a3a0-2250da0adb9c password=newKPasswd45
savedEntity=Customer [userId=4, email=sdass@demo.com, password=newKPasswd45, firstname=Subra, lastname=Dass, enabled=true, createdOn=2017-05-25 17:00:00.0, resetToken=null, resetTokenExpire=2017-08-01 17:00:00.0]

password changed.
------