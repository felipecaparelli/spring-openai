# Spring OpenAI Integration project

This project is the source code using in the article Integrate Spring with Open AI - Dzone.com 

## How to use

1. Get API Access
Sign up at [OpenAI&#39;s website](https://platform.openai.com/signup), if you don&rsquo;t have an account yet and create an API key from the API dashboard.

2. Basic configuration
On your configuration file (**application.properties**), set the OpenAI secret key in the property `openai.api.key`. You can also replace the model version on the properties file to use a different API version, like `gpt-4o-mini`.

3. Add the OpenAI SSL certificate to yout cacerts file
A tricky part about connecting with this service via Java, is that it will require you to have a valid certificate while executing this request. To fix it we will need to execute some important steps:</p>

3.1 Download the certificate available in the OpenAI website

Access the URL on your browser - in this example, I will be using Google Chrome to do it - and open the certificate details. There is a little icon near to the URL. Click it, and select the option **Connection is secure**. Then, click the icon near the text **Certificate is valid**, it will show the certificate details. Select the tab **Details**, and finally, click **Export**.&nbsp;

3.2 Add the certificate to your cacerts file
You will need to add this certificate inside the cacerts file (keystore), available on your JDK installation. It will allow your request to be validated by the OpenAI server. To add this certificate to your Java cacerts files, you will need to open your a command line terminal (**Administrator mode**) and execute the following instruction: `keytool -import -alias openai -keystore "C:\Program Files\Java\jdk-17\lib\security\cacerts" -file openai.crt`

4. Start your Spring application
Run the following command to start your app: `./mvnw spring-boot:run`

5. Call your REST API
Open your browser with the following: `https://localhost:8080/ask?prompt=What is scuba`. Then, if your API secret key is fine, and you have added a credit card to your OpenAI account, then you will be able to see the response provided by the ChatGPT application.