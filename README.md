# Redis
Redis is an open-source data structure server that is commonly used as a database, cache, or message broker. It has the capability to read and write data quickly, making it a popular choice for high-performance applications. Redis stores data in key-value pairs and offers various data structures (such as lists, sets, hashes, etc.), providing flexibility in its usage.
- Caching: It speeds up database queries by keeping frequently accessed data in memory. 
- Data Storage: It can be used for both persistent and temporary data storage, especially advantageous in high-speed applications. 
- Real-Time Analytics: Suitable for processing and analyzing streaming data in real time. 
- Messaging: It enables real-time communication and messaging systems using the Pub/Sub model. 
- Game Development: Used for managing in-game states (scores, session data, etc.) quickly.

### Redis Connection Settings

- **spring.data.redis.host**
    
    This setting specifies the address of the Redis server. Typically, "localhost" is used for a local server, while an IP address or domain name can be provided for a remote server. It is essential to set this value correctly for your application to connect to the Redis server.

- **spring.data.redis.port**
    
    This setting defines the port number on which the Redis server is listening. By default, Redis runs on port 6379. If your Redis server operates on a different port, you should update this setting to specify the correct port.

- **spring.data.redis.connect-timeout**
    
    This setting determines the maximum time to wait (in milliseconds) for a connection to the Redis server. If a connection cannot be established within this timeframe, an error is returned. It is important to choose an appropriate value for your application's performance; a very short timeout may lead to connection errors, while a very long timeout could negatively impact your application's response time.

### Pool Settings (for Lettuce)

Lettuce is a library that allows you to establish asynchronous connections with Redis. The following settings manage the connection pool:
- **spring.data.redis.lettuce.pool.max-idle=8**

    This setting specifies the maximum number of idle connections that can be maintained in the pool. Having too many idle connections can lead to resource wastage. A lower value may reduce memory consumption.


- **spring.data.redis.lettuce.pool.min-idle=0**

    This setting indicates the minimum number of idle connections that must be maintained in the pool. When set to 0, there is no requirement for idle connections in the pool. However, setting a specific value can reduce connection establishment time.


- **spring.data.redis.lettuce.pool.max-active=8**
  
    This setting defines the maximum number of active connections (in use) allowed at the same time. Requests that exceed this limit will have to wait. A lower value allows fewer concurrent requests, which can impact performance.


- **spring.data.redis.lettuce.pool.max-wait=10000**

    This setting specifies the maximum time to wait (in milliseconds) for an idle connection to become available when none are present in the pool. If a connection is not available within the specified time, an error is returned. A very high value can negatively affect your application's response time.

## To run the project:

1. Build the project.
```
mvn clean package
```
2. Using Docker Compose.
```
docker-compose up --build
```

