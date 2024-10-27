# Use an official JDK image as a base
FROM maven:3.8.6-openjdk-11

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml and download dependencies
COPY pom.xml /app/
RUN mvn dependency:resolve

# Copy the rest of the project files into the container
COPY . /app

# Run the tests
CMD ["mvn", "clean", "verify"]