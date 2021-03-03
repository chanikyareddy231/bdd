
Feature: create posts

Scenario:
Given register end point like "https://jsonplaceholder.typicode.com/posts"
Then validate the restful service
 |  uid  |  id  |  title  |           body                 |  criteria  |  sc  |
 |  10   |  101 |  wishes |  all the best rahul gandhi     |  unique    |  201 | 
 |  10   |  102 |  wishes |  do singing in haven---Mr.Balu |  unique    |  201 | 
 |  10   |  102 |  wishes |  do singing in haven---Mr.Balu |  duplicate |  200 | 