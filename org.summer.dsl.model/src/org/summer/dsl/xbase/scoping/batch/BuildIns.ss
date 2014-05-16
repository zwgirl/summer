module summer.lang.BuildIns{
	
	<Object />
	export class Object{   
		constructor (){}       
		 
		function  create():Object{         
		}
		function  defineProperties(Object obj, String name, Object obj2) {}
		function  defineProperty(){}
		function  freeze(){}   
//	function getOwnPropertyDescriptor(){}
//	function getOwnPropertyNames(){}   
//	function getPrototypeOf(){return null;}
		function  is():Boolean{}
		function  isExtensible():Boolean{}   
		function  isFrozen():Boolean{} 
		function  isSealed():Boolean{}  
		
		const static Type Type;
		
		function getType():Type{}
//	function Collection<String> keys(){return null} 
//	function preventExtensions(){}
//	function seal(){}
//	function setPrototypeOf(){}
	}  
	
	export class Type extends Object{
		constructor(String name,Function ctos,Type[] baseTypes, boolean isInterface){
		}
		
		function IsValueType():Boolean{}
		function IsInstanceOfType(Object o):Boolean {  }
	        
	    function IsSubclassOf(Type c):boolean{}
	    
	     function 		IsAssignableFrom(Type c):boolean{} 
	     
	     function  ImplementInterface(Type ifaceType) :boolean{}
	 
	 
	   function GetInterfaces():Type[]{ }
	 
		function GetType():Type{}
			
		function	toString():String{}
		function GetProperty(String name, int flag):Object{}
		 	static int GlobalIndex = 0;
			int Id;
			Function Constructor;
			String Name;
			Type[] Interfaces;
			
			Type BaseType;
			Boolean IsInterface;
	}
	 
	export class String extends Object{ 
		constructor(){
		}   
		
	   function  +(String left, String right):String{}
		
		function operator_equals(String left, String right):Boolean{}
		 
		/**
	 * Returns the character at the specified index.
	 */ 
		function  charAt(Number index):String{}  
	
		/**
	 * Returns a number indicating the Unicode value of the character at the given index.
	 */
		function  charCodeAt():String{}
	
		/**
	 * Returns a non-negative integer that is the UTF-16 encoded code point value at the given position.
	 */
		function  codePointAt(Number index):Number {}
	
		/**
	 * Combines the text of two strings and returns a new string.
	 */
//	function  concat(String ... string2):String{}
	
		/**
	 * Determines whether one string may be found within another string.
	 */
		function  contains():String {}
		
		/**
	 * Determines whether a string ends with the characters of another string.
	 */
		function  endsWith():Boolean {}
		
		/**
	 * Returns the index within the calling String object of the first occurrence of the specified value, or -1 if not found.
	 */
		function  indexOf(String searchValue, Number fromIndex):Number{}
		
		/**
	 * Returns the index within the calling String object of the last occurrence of the specified value, or -1 if not found.
	 */
		function  lastIndexOf(String searchValue, Number fromIndex):Number{}
	
		/**
	 * Returns a number indicating whether a reference string comes before or after or is the same as the given string in sort order.
	 */
		function  localeCompare(String param):Number{}
		
		/**
	 * Used to match a regular expression against a string.
	 */
//	function  match(RegExp patern){ }
		/**
	 * Wraps the string in double quotes (""").
	 */
		function  quote() {return }
		
		/**
	 * Returns a string consisting of the elements of the object repeated the given times.
	 */
		function  repeat() {return }
		
		/**
	 * Used to find a match between a regular expression and a string, and to replace the matched substring with a new substring.
	 */
		function  replace(){}
		
		/**
	 * Executes the search for a match between a regular expression and a specified string.
	 */
		function  search(){}
		
		/**
	 * Extracts a section of a string and returns a new string.
	 */
		function  slice(){}
	
		/**
	 * Splits a String object into an array of strings by separating the string into substrings.
	 */
		function split(String separator, Number limit ):String[] {}
		
		/**
	 * Determines whether a string begins with the characters of another string.
	 */
		function  startsWith() {}
	
		/**
	 * Returns the characters in a string beginning at the specified location through the specified number of characters.
	 */
		function   substr(){}
		/**
	 * Returns the characters in a string between two indexes into the string.
	 */
		function   substring(){}
		/**
	 * The characters within a string are converted to lower case while respecting the current locale. For most languages, this will return the same as toLowerCase.
	 */
		function   toLocaleLowerCase(){}
	
		/**
	 * The characters within a string are converted to upper case while respecting the current locale. For most languages, this will return the same as toUpperCase.
	 */
		function   toLocaleUpperCase(){}
		
		/**
	 * Returns the calling string value converted to lower case.
	 */
		function   toLowerCase(){}
		/**
	 * Returns an object literal representing the specified object; you can use this value to create a new object. Overrides the Object.prototype.toSource method.
	 */
		function   toSource() {}
		/**
	 * Returns a string representing the specified object. Overrides the Object.prototype.toString method.
	 */
//	function override  String toString(){}
		
		/**
	 * Returns the calling string value converted to uppercase.
	 */
		function   toUpperCase(){}
		
		/**
	 * Trims whitespace from the beginning and end of the string. Part of the ECMAScript 5 standard.
	 */
		function   trim(){}
		
		/**
	 * Trims whitespace from the left side of the string.
	 */
		function   trimLeft():String {}
		
		/**
	 * Trims whitespace from the right side of the string.
	 */
		function  trimRight():String {}
		
		/**
	 * Returns the primitive value of the specified object. Overrides the Object.prototype.valueOf method.
	 */
		function  valueOf():String{}
		 
	} 
	export class Boolean extends Object{
		constructor (Object value){} 
		
		constructor (){}
		 
	}
	
	export class Number extends Object{
//	public static final Number MAX_VALUE = 1.7976931348623157E+308
//	public static final Number MIN_VALUE = 5E-324
		static const Object NaN = new Object();          
//	public static final Object NEGATIVE_INFINITY = new Object()
//	public static final Object POSITIVE_INFINITY = new Object()
		function  + (Number lhs, Number rhs){
			
		} 
		
		function  += (Number lhs, Number rhs){
			
		} 
		
		function operator_plus(Number lhs, Number rhs){
			
		} 
		
		function < <  (Number lhs, Number rhs){
			
		}
	}
	
	export class Byte extends Number{
		
	}
	
	export class Short extends Number{
		
	}
	
	export class Integer extends Number{
		
	}
	
	export class Float extends Number{
		
	}
	
	export class Double extends Number{
		
	}
	
	export class Maths{
		
	}
	
	export class Array<T> extends Object{
//	function void forEach(Action callback, T thisObject){}
//	function  splice(Number index, Number howMany, T ... elements):Array<T>{}
//	function Array<T> slice( Number begin ,Number end ){}
//	function  pop():T{}
//	function Void push(T... objs){}
	
		function [(Integer index):T{
			
		}
		 Integer length;
		
	}
	
	export struct IteratorResult/*<T> */{
//	Boolean done; 
//	T value;
	}
	
	export interface Iterator<T> {
		
		function next() : IteratorResult<T>{
			
		}
	}
	
	export interface Iterable<T> {
			function iterator():Iterator<T>{
			
		}
	}
	
	export class Collection<T> extends Object implements Iterable<T> {  
		
	}
	
	export class List<T> extends Collection<T>{
		
	}
	
	export class ArrayList<T> implements List<T>{
		
	}
	
	export class LinkedList<T> implements List<T>{
		
	}
	
	export class Entry<K, V>{
		constructor(K key, V value){
			this.key = key;
			this.value = value;
		}
		
//	K key;
//	V value;
	}
	
//export class Map<K, V> extends Collection<Entry<K, V>> {  
		
//	Integer size;//返回成员总数。
////	function ^set(K key, V value) {}//设置一个键值对。
////	function ^get(key):V{} //读取一个键。
////	function has(key):Boolean{} //返回一个布尔值，表示某个键是否在Map数据结构中。
////	function clear(){} //清除所有成员。
//	
//
////  import {Name} from '@name';
////  const keysName = new Name;  // These should be non global.
////  const valsName = new Name;
//
//    constructor(Iterable<Entry<K, V> >iterable /* = []*/) {
////      this[keysName] = [];
////      this[valsName] = [];
////      for (let [k, v] of iterable) {
////        this.set(k, v);
////      } 
//    }
////    function ^get(K key) :V{
//////      const keys = this[keysName];
//////      const i = indexOfIdentical(keys, key);
//////      return i < 0 ? undefined : this[valsName][i];
////    }
//    function has(K key):Boolean {
////      const keys = this[keysName];
////      return indexOfIdentical(keys, key) >= 0;
//    }
////    function ^set(K key, V val) { 
//////      const keys = this[keysName];
//////      const vals = this[valsName];
//////      let i = indexOfIdentical(keys, key);
//////      if (i < 0) { i = keys.length; }
//////      keys[i] = key;
//////      vals[i] = val;
////    }
//    function delete(K key):Boolean {
////      const keys = this[keysName];
////      const vals = this[valsName];
////      const i = indexOfIdentical(keys, key);
////      if (i < 0) { return false; }
////      keys.splice(i, 1);
////      vals.splice(i, 1);
////      return true;          
//    }
//    function  items():Iterator<Entry<K,V> > {
////      for (var i = 0; i < this[keysName].length; i++) {
////        yield [this[keysName][i], this[valsName][i]];
////      }
//    }
//    function  keys():Iterator<K> {
////      for (var i = 0; i < this[keysName].length; i++) {
////        yield this[keysName][i];
////      }
//    }
//    function values() :Iterator<V>{
////      for (var i = 0; i < this[keysName].length; i++) {
////        yield this[valsName][i];
////      }
//    }
//  }
	
	export class RegExp extends Object{
		constructor (String pattern, String flags){}
	}
	
	export  class Error extends Object{
		
	} 
	
	export class Set<T extends Object> extends Object{
		constructor(){
			
		}
	
//	Integer size; //返回成员总数。
//	function add(T value){} //添加某个值。
//	function delete(T value){} //：删除某个值。
//	function has(T value):Boolean{} //：返回一个布尔值，表示该值是否为set的成员。
//	function clear(){}//：清除所有成员。
	}
	 
	export class Function extends Object{ 
		constructor(){
			
		}
		 
		function apply(){
			
		}
		
		function call(){
			
		}
	}
	
	export class Void extends Object{
		
	}

}

