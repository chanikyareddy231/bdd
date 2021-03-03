
Feature: get employees details

Background:
Given register end point like "https://jsonplaceholder.typicode.com/posts"
And define HTTP request

@smoketest
Scenario: get all posts
When submit request via get method to Restfull service
Then status code is "200" and content type is "application/json"

Scenario: get specific post
When submit request for id "1" via get method to Restfull service
Then status code is "200" and id is "1" in json response
