# MAT

## Problem Solution: Approach

+ Generate all odd length and even length palindromes.

+ To generate the odd length palindromes:
++ Fix a single center and expand in both directions to look for longer palindromes.

+ To generate the even length palindromes:
++ Fix two centers and expand in both directions to look for longer palindromes.

+ Store all the palindromes in the customised data structure. Eg. NavigableMap structure of the input string - "aab"
```
{
	2=longest_unique_palindrome.PalinMapData {
	 	textSet = [aa],
	 	indexSet = [0]
	 }, 
	 1=longest_unique_palindrome.PalinMapData {
		textSet = [a, b],
	 	indexSet = [0, 2]
	 }
}
```

+ Print the top N longest unique palindromes.

+ Time Complexity: O(n^2)

### Problem Solution: Further Thoughts

#### Does an O(N) solution exist ?

+ Manacher’s Algorithm can be used.

+ Implemented the O(n^2) solution since I was supposed to complete the solution within an hour or two.


## Source Code: Directory Structure

```
|   README.md
|
+---bin
|   \---longest_unique_palindrome
|           Main.class
|           Palindrome.class
|           PalinMapData.class
|
\---src
    \---longest_unique_palindrome
            Main.java
            Palindrome.java
            PalinMapData.java

```			
			
## How to Build:

```
cd src

javac -d ../bin longest_unique_palindrome/*.java
```

The src has been already compiled. Do compile if any changes have been made to the original source.

## How to Run:

```
cd bin
```

### To print the top N longest unique palindromes

```
java longest_unique_palindrome.Main <Input String> <Top N>
```

### To print all the unique palindromes

```
java longest_unique_palindrome.Main <Input String>
```

### Test Runs

#### Run 1

java longest_unique_palindrome.Main sqrrqabccbatudefggfedvwhijkllkjihxymnnmzpop 3

```
Text: hijkllkjih, Index: 23, Length: 10


Text: defggfed, Index: 13, Length: 8


Text: abccba, Index: 5, Length: 6
```

#### Run 2

java longest_unique_palindrome.Main sqrrqabccbatudefggfedvwhijkllkjihxymnnmzpop

```
Text: hijkllkjih, Index: 23, Length: 10


Text: defggfed, Index: 13, Length: 8


Text: abccba, Index: 5, Length: 6


Text: qrrq, Index: 1, Length: 4
Text: mnnm, Index: 35, Length: 4


Text: pop, Index: 40, Length: 3


Text: s, Index: 0, Length: 1
Text: q, Index: 1, Length: 1
Text: r, Index: 2, Length: 1
Text: a, Index: 5, Length: 1
Text: b, Index: 6, Length: 1
Text: c, Index: 7, Length: 1
Text: t, Index: 11, Length: 1
Text: u, Index: 12, Length: 1
Text: d, Index: 13, Length: 1
Text: e, Index: 14, Length: 1
Text: f, Index: 15, Length: 1
Text: g, Index: 16, Length: 1
Text: v, Index: 21, Length: 1
Text: w, Index: 22, Length: 1
Text: h, Index: 23, Length: 1
Text: i, Index: 24, Length: 1
Text: j, Index: 25, Length: 1
Text: k, Index: 26, Length: 1
Text: l, Index: 27, Length: 1
Text: x, Index: 33, Length: 1
Text: y, Index: 34, Length: 1
Text: m, Index: 35, Length: 1
Text: n, Index: 36, Length: 1
Text: z, Index: 39, Length: 1
Text: p, Index: 40, Length: 1
Text: o, Index: 41, Length: 1
```

#### Run 3

java longest_unique_palindrome.Main aaaa 1

```
Text: aaaa, Index: 0, Length: 4
```

#### Run 4

java longest_unique_palindrome.Main aaaa

```
Text: aaaa, Index: 0, Length: 4


Text: aaa, Index: 0, Length: 3


Text: aa, Index: 0, Length: 2


Text: a, Index: 0, Length: 1
```

#### Run 5

java longest_unique_palindrome.Main aaab

```
Text: aaa, Index: 0, Length: 3


Text: aa, Index: 0, Length: 2


Text: a, Index: 0, Length: 1
Text: b, Index: 3, Length: 1
```

#### Run 6
java longest_unique_palindrome.Main aaab aaab

```
Follow the below pattern to run the program -
java longest_unique_palindrome.Main <Input String> <Top N>
(Or)
java longest_unique_palindrome.Main <Input String>
```
