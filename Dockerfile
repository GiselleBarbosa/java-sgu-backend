# Usa a imagem oficial do OpenJDK 17 como base
FROM openjdk:17-alpine

# Define o diretório de trabalho como /app
WORKDIR /app

# Copia o jar do seu aplicativo para o contêiner
COPY sgu-gerenciamento/target/sgu-gerenciamento-0.0.1-SNAPSHOT.jar /app/app.jar

# Define o comando padrão a ser executado quando o contêiner for iniciado
CMD ["java", "-jar", "app.jar"]