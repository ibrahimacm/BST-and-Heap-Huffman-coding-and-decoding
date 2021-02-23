tree will be Preorder Traversal.
# symbol is used to represent the null node.
for root (just total frequency for children). 
for parent (just total frequency for children, 0 or 1).
for leaf node (character, frequncey, 0 or 1).
0 = left edge.
1 = right edge.

[Note: you will have .dot file , to open it you need graphViz program. (you will have picture of graph tree for this example)]

for example :-

the input text is: 
bccabbddaeccbbaeddcc

tree for the text:
              (20)
	0/           \1
       (9)          (11)
      0/   \1        0/    \1
 (d, 4)    (5)   (b, 5)  (c, 6)
         0/   \1 
    (e, 2)   (a, 3)


so, will save it in text file like this:-

tree:
(20) (9, 0) (d, 4, 0) # # (5, 1) (e, 2, 0) # # (a, 3, 1) # # (11, 1) (b, 5, 0) # # (c, 6, 1) # #

encoding is:
101111011101000000110101111101001101000001111

The size before Huffman coding: 
160

The size after Huffman coding: 
105

Table:
|    Letter	|	Count	|	Code	|
       d	   	   4		 00
       c	   	   6		 11
       b	   	   5		 10
       a	   	   3		 011
       e	   	   2		 010



