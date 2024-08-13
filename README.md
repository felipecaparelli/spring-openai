# Spring OpenAI Integration project

This project is the source code using in the article Integrate Spring with Open AI - Dzone.com 

## How to use

1. Get API Access
Sign up at [OpenAI&#39;s website](https://platform.openai.com/signup), if you don&rsquo;t have an account yet and create an API key from the API dashboard.

2. Basic configuration
On your configuration file (**application.properties**), set the OpenAI secret key in the property `openai.api.key`. You can also replace the model version on the properties file to use a different API version, like `gpt-4o-mini`.

3. Start your Spring application
Run the following command to start your app: `./mvnw spring-boot:run`

4. Call your REST API
Open your browser with the following: `https://localhost:8080/ask?prompt=What is scuba`. Then, if your API secret key is fine, and you have added a credit card to your OpenAI account, then you will be able to see the response provided by the ChatGPT application.