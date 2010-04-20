/*
 * ome.xml.r201004.Reference
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

public class Reference extends Object
{
	// -- Instance variables --

	// -- Constructors --

	/** Constructs a Reference. */
	public Reference()
	{
	}

	// -- Reference API methods --

	public Element asXMLElement(Document document)
	{
		// Creating XML block for Reference
		Element Reference_element = document.createElement("Reference");
		return Reference_element;
	}

	public static Reference fromXMLElement(Element element)
		throws EnumerationException
	{
		String tagName = element.getTagName();
		if (!"Reference".equals(tagName))
		{
			// TODO: Should be its own Exception
			throw new RuntimeException(String.format(
					"Expecting node name of Reference got %s",
					tagName));
		}
		Reference instance = new Reference();
		return instance;
	}
}
