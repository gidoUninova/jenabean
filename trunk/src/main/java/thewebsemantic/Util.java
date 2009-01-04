package thewebsemantic;

public class Util {
	public static String last(String path) {
		return end(path, '/');
	}
	
	private static String end(String s, char c) {
		int i = s.lastIndexOf(c);
		return (i > 0) ? s.substring(i+1) : s;
	}
	
	public static String toProperCase(String text) {
		if ((text == null) || (text.length() == 0))
			return text;
		else if (text.length() == 1)
			return text.toUpperCase();
		else
			return new StringBuilder().
			append(text.substring(0, 1).toUpperCase()).
			append(text.substring(1)).
			toString();
	}

    public static String getRdfType(Class<?> c) {
        RdfType rdfType = c.getAnnotation(RdfType.class);
        return (rdfType != null) ? rdfType.value(): c.getSimpleName();
    }
}
/*
	Copyright (c) 2007 
	
	Permission is hereby granted, free of charge, to any person obtaining a copy
	of this software and associated documentation files (the "Software"), to deal
	in the Software without restriction, including without limitation the rights
	to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
	copies of the Software, and to permit persons to whom the Software is
	furnished to do so, subject to the following conditions:
	
	The above copyright notice and this permission notice shall be included in
	all copies or substantial portions of the Software.
	
	THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
	IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
	FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
	AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
	LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
	OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
	THE SOFTWARE.
*/