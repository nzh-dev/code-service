# code-service
My first GitHub project - code-service

# Create DB Container
docker build -t nzh-dev-postgres .

# Start Containers
docker-compose up

# Stop Containers
docker-compose down

# Setup
# DB Container - nzh-dev-postgres

# List running containers
docker ps

# Login to container
docker exec -it <container id or name> /bin/bash

# Start Spring Boot application - backend
gradle build && java -jar backend/build/libs/backend-0.0.1-SNAPSHOT.jar