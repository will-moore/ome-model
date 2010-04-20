/*
 * ome.xml.r201004.Text
 *
 *-----------------------------------------------------------------------------
 *
 *  Copyright (C) 2010 Open Microscopy Environment
 *      Massachusetts Institute of Technology,
 *      National Institutes of Health,
 *      University of Dundee,
 *      University of Wisconsin-Madison
 *
 *
 *
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU Lesser General Public
 *    License as published by the Free Software Foundation; either
 *    version 2.1 of the License, or (at your option) any later version.
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *    Lesser General Public License for more details.
 *
 *    You should have received a copy of the GNU Lesser General Public
 *    License along with this library; if not, write to the Free Software
 *    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 *-----------------------------------------------------------------------------
 */

/*-----------------------------------------------------------------------------
 *
 * THIS IS AUTOMATICALLY GENERATED CODE.  DO NOT MODIFY.
 * Created by callan via xsd-fu on 2010-04-20 12:31:20+0100
 *
 *-----------------------------------------------------------------------------
 */

package ome.xml.r201004;

import java.util.ArrayList;
import java.util.List;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ome.xml.r201004.enums.*;

public class Text extends Object
{
	// -- Instance variables --

	// Property
	private Double y;

	// Property
	private Double x;

	// Property
	private String value;

	// -- Constructors --

	/** Constructs a Text. */
	public Text()
	{
	}

	// -- Text API methods --

	// Property
	public Double getY()
	{
		return y;
	}

	public void setY(Double y)
	{
		this.y = y;
	}

	// Property
	public Double getX()
	{
		return x;
	}

	public void setX(Double x)
	{
		this.x = x;
	}

	// Property
	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

	public Element asXMLElement(Document document)
	{
		// Creating XML block for Text
		Element Text_element = document.createElement("Text");
		if (y != null)
		{
			// Attribute property Y
			Text_element.setAttribute("Y", y.toString());
		}
		if (x != null)
		{
			// Attribute property X
			Text_element.setAttribute("X", x.toString());
		}
		if (value != null)
		{
			// Element property Value which is not complex (has no
			// sub-elements)
			Element value_element = document.createElement("Value");
			value_element.setTextContent(value);
			Text_element.appendChild(value_element);
		}
		return Text_element;
	}

	public static Text fromXMLElement(Element element)
		throws EnumerationException
	{
		String tagName = element.getTagName();
		if (!"Text".equals(tagName))
		{
			// TODO: Should be its own Exception
			throw new RuntimeException(String.format(
					"Expecting node name of Text got %s",
					tagName));
		}
		Text instance = new Text();
		if (element.hasAttribute("Y"))
		{
			// Attribute property Y
			instance.setY(Double.valueOf(
					element.getAttribute("Y")));
		}
		if (element.hasAttribute("X"))
		{
			// Attribute property X
			instance.setX(Double.valueOf(
					element.getAttribute("X")));
		}
		NodeList Value_nodeList = element.getElementsByTagName("Value");
		if (Value_nodeList.getLength() > 1)
		{
			// TODO: Should be its own Exception
			throw new RuntimeException(String.format(
					"Value node list size %d != 1",
					Value_nodeList.getLength()));
		}
		else if (Value_nodeList.getLength() != 0)
		{
			// Element property Value which is not complex (has no
			// sub-elements)
			instance.setValue(Value_nodeList.item(0).getTextContent());
		}
		return instance;
	}
}
