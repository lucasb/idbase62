ID Base62
========

[![Build Status](http://img.shields.io/travis/lucasb/idbase62/master.svg)](https://travis-ci.org/lucasb/idbase62)
[![Coverage Status](http://img.shields.io/coveralls/lucasb/idbase62/master.svg)](https://coveralls.io/github/lucasb/idbase62?branch=master)

Project to generate sequential identification with base 62.

This lib helps generate short identifications to use in friendly URLs. For building IDs, it is using Base 62 that is all ASCII letters (upper and lower case) [a-z A-Z] and numbers [0-9].

<pre>
  ID decimal: 1413324470488
  <b>ID Base62:  ySHP1FC</b>
</pre>

Using as ID in Entity
-----
You can use it like a type in your Java Object to get new IDs <code>private Identification id;</code>.
- <code>next()</code> method allows you to get next one in sequence;
- <code>before()</code> method allows you to get before one in sequence;
- <code>equals()</code> method to test if to values is equals.

Calculating with Base 62
-----
The Base62 class has methods to calculate Base62 elements and convert from/to Base10.
- <code>fromDecimal()</code> convert from decimal to Base62;
- <code>toDecimal()</code> convert from Base62 to decimal;
- <code>isValid()</code> verify if value is a valid Base62 element;
- <code>plus()</code> sum two Base62 elements;
- <code>minus()</code> subtract two Base62 elements.
