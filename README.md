# Developing a Spring Cloud Native App (part-2)

configuration-source: https://github.com/mehdihasan/cloud-config-bd-tolls


#### STEP BY STEP APPLICATION DEVELOPMENT:
1. Developing the Config server and app
    1. First, an git based config server 
    2. On the config server, we have @EnableConfigServer, set the app port, git property uri, search path and performance test git repos
    3. Then, we have created a cloud config app
    4. At the config app, we have set the application name, active profile and the cloud config server uri
    5. We have enabled basic security for the config server
    6. Then we have enabled encryption in the server side and decryption in the client side. We may need some value to be encrypted which may can only readable by the client app.
2. Developing a Serverless app
    1. Creating the environment:
        1. Install a mysql server in docker on port 3301. Created a database named “cloud-native-app-ps2”
        2. Create a RabbitMQ server and run the RabbitMQ management plugin as well command
        ```bash
        docker run -d --name rabbit -p 15672:15672 -p 5672:5672 rabbitmq:3-management
        ```
    2. toll process task. Which is a short lived task lived on my local maven repo (server less technology.  
    3. Second, created a Task-sink app which will listen to the bus and kick off the task.
    4. Third, modifying the config-app to make a TaskIntake app which to be used to raise up the TaskSink app.
    5. Now making a POST request to localhost:8080/tasks (with body of station100,MEHDI309,2019-11-21T01:28:22) will live the task in you can find the updated values at the mysql database.
3. …

