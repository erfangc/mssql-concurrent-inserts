# README

This repo demonstrates how to create a stored procedure that turns a non-idempotent table into an idempotent one by
wrapping transaction with another table

## Docker Cmd to Run Sql Server

```bash
docker run -e "ACCEPT_EULA=Y" -e SA_PASSWORD='StrongPassword(!)' -p 1433:1433 -d mcr.microsoft.com/mssql/server:2019-latest
```
