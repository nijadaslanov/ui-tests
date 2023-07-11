#!/bin/sh

aws sso login --profile automation-api-test
clear
read -p "Press enter to continue the process"
export CODEARTIFACT_AUTH_TOKEN=`aws codeartifact get-authorization-token --domain viacustomers --domain-owner 214454900609 --query authorizationToken --output text --profile automation-api-test --region us-west-2`
echo $CODEARTIFACT_AUTH_TOKEN