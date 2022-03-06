# README

This repo demonstrates how to create a stored procedure that turns a non-idempotent table into an idempotent one by
wrapping transaction with another table

## Docker Cmd to Run Sql Server

```bash
docker run -e "ACCEPT_EULA=Y" -e SA_PASSWORD='StrongPassword(!)' -p 1433:1433 -d mcr.microsoft.com/mssql/server:2019-latest
```

```
Hi Mackenzie, Amber – 

I made several changes to the way we synchronize accounts/members from Folio -> Alternatives platform over the weekend. These are now waiting approval by DBAs as these changes contain items they must action

Let’s follow-up and ensure:

-	The following code changes are approved and merged by DBAs (they are Cc-ed on the PR itself – and I’ve tagged and reached out)
https://stash.foliofn.com/projects/DEV/repos/alternative-batch/pull-requests/26/overview
-	The following two DBA tickets are actioned (after the PR above is merged)
https://jira.foliofn.com/browse/DBA-18417
https://jira.foliofn.com/browse/DBA-18434
(Loc Nguyen must action both)

What’s the change:
1.	We are adding a lot more fields we are loading from Folio members/accounts – including Accreditation answers as well addresses, title, suffix etc.
2.	We are now tracking changes – such that if an account is closed, restricted (placed under sanction for example) they will be promptly deleted from Alternatives platform to avoid transactions on them

Failure to merge in these changes:
1.	Member / account data not up to date
2.	No accreditation and other important fields

Thank you,
Erfang 
```
