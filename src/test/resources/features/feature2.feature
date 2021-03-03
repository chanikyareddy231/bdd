
Feature: post creation

@smoketest
Scenario Outline: create a new post
Given register end point like "https://jsonplaceholder.typicode.com/posts"
And define HTTP request
When submit request via post with "<uid>","<id>","<title>",and "<body>" to service
Then status code is "<sc>" as per "<criteria>" and content type is "application/json"
Examples:
 |  uid  |  id  |  title  |           body                 |  criteria  |  sc  |
 |  10   |  101 |  wishes |  all the best rahul gandhi     |  unique    |  201 | 
 |  10   |  102 |  wishes |  do singing in haven---Mr.Balu |  unique    |  201 | 
 |  10   |  102 |  wishes |  do singing in haven---Mr.Balu |  duplicate |  200 | 