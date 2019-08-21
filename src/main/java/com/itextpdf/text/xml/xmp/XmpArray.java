/*
 * $Id: 3fb1fdd9c5ca64a43caa8e1db1d40c7fb77eb6e6 $
 *
 * This file is part of the iText (R) project.
 * Copyright (c) 1998-2015 iText Group NV
 * Authors: Bruno Lowagie, Paulo Soares, et al.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License version 3
 * as published by the Free Software Foundation with the addition of the
 * following permission added to Section 15 as permitted in Section 7(a):
 * FOR ANY PART OF THE COVERED WORK IN WHICH THE COPYRIGHT IS OWNED BY
 * ITEXT GROUP. ITEXT GROUP DISCLAIMS THE WARRANTY OF NON INFRINGEMENT
 * OF THIRD PARTY RIGHTS
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Affero General Public License for more details.
 * You should have received a copy of the GNU Affero General Public License
 * along with this program; if not, see http://www.gnu.org/licenses or write to
 * the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor,
 * Boston, MA, 02110-1301 USA, or download the license from the following URL:
 * http://itextpdf.com/terms-of-use/
 *
 * The interactive user interfaces in modified source and object code versions
 * of this program must display Appropriate Legal Notices, as required under
 * Section 5 of the GNU Affero General Public License.
 *
 * In accordance with Section 7(b) of the GNU Affero General Public License,
 * a covered work must retain the producer line in every PDF that is created
 * or manipulated using iText.
 *
 * You can be released from the requirements of the license by purchasing
 * a commercial license. Buying such a license is mandatory as soon as you
 * develop commercial activities involving the iText software without
 * disclosing the source code of your own applications.
 * These activities include: offering paid services to customers as an ASP,
 * serving PDFs on the fly in a web application, shipping iText with a closed
 * source product.
 *
 * For more information, please contact iText Software Corp. at this
 * address: sales@itextpdf.com
 */
package com.itextpdf.text.xml.xmp;

import java.util.ArrayList;

import com.itextpdf.text.xml.XMLUtil;

/**
 * StringBuffer to construct an XMP array.
 */
@Deprecated
public class XmpArray extends ArrayList<String> {

	private static final long serialVersionUID = 5722854116328732742L;
	/** An array that is unordered. */
	public static final String UNORDERED = "rdf:Bag";
	/** An array that is ordered. */
	public static final String ORDERED = "rdf:Seq";
	/** An array with alternatives. */
	public static final String ALTERNATIVE = "rdf:Alt";

	/** the type of array. */
	protected String type;

	/**
	 * Creates an XmpArray.
	 * @param type the type of array: UNORDERED, ORDERED or ALTERNATIVE.
	 */
	public XmpArray(String type) {
		this.type = type;
	}

	/**
	 * Returns the String representation of the XmpArray.
	 * @return a String representation
	 */
	@Override
    public String toString() {
		StringBuffer buf = new StringBuffer("<");
		buf.append(type);
		buf.append('>');
		String s;
		for (String string : this) {
			s = string;
			buf.append("<rdf:li>");
			buf.append(XMLUtil.escapeXML(s, false));
			buf.append("</rdf:li>");
		}
		buf.append("</");
		buf.append(type);
		buf.append('>');
		return buf.toString();
	}
}