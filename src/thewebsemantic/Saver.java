package thewebsemantic;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;

import com.hp.hpl.jena.datatypes.xsd.XSDDatatype;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;


abstract class Saver {
	
	Model m;
	Resource s;
	Property p;

	public Saver(Resource subject, Property property) {
		m = subject.getModel();
		s = subject;
		p = property;
	}

	public abstract void save(Literal l);
	
	public void save(double v) {
		save(m.createTypedLiteral(v));	
	}

	
	public void save(long v) {
		save(m.createTypedLiteral(v));	
	}

	
	public void save(int v) {
		save(m.createTypedLiteral(v));	
	}

	
	public void save(char c) {
		save(m.createTypedLiteral(c));	
	}

	
	public void save(boolean b) {
		save(m.createTypedLiteral(b));	
	}
	
	
	public void save(float v) {
		save(m.createTypedLiteral(v));	
	}

	
	public void save(String s) {
		save(m.createTypedLiteral(s));	
	}

	public void save(BigInteger v) {
		save(m.createTypedLiteral(v));
	}
	
	public void save(BigDecimal v) {
		save(m.createTypedLiteral(v, XSDDatatype.XSDdecimal));
	}
	
	public void save(Date d) {
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		save(m.createTypedLiteral(c));	
	}

	public void save(Calendar c) {
		save(m.createTypedLiteral(c));	
	}
	
	public void write(Object o) {	
		if (o instanceof String)
			save(o.toString());
		else if (o instanceof Date)
			save((Date) o);
		else if (o instanceof Integer)
			save((Integer) o);
		else if (o instanceof Long)
			save((Long) o);
		else if (o instanceof Float)
			save((Float) o);
		else if (o instanceof Double)
			save((Double) o);
		else if (o instanceof Character)
			save((Character) o);
		else if (o instanceof Boolean)
			save((Boolean) o);
		else if (o instanceof Calendar)
			save((Calendar) o);
		else if (o instanceof BigInteger)
			save((BigInteger) o);
		else if (o instanceof BigDecimal)
			save((BigDecimal) o);
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