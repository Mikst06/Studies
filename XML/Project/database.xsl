<?xml version="1.0"?>

<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:xs="http://www.w3.org/2001/XMLSchema"
                xmlns:exsl="http://exslt.org/common"
                extension-element-prefixes="exsl">
  <xsl:output method="html"/>

<xsl:template match="/">
	<html>
		<body>
				<h2 style="text-align:center">Books</h2>
				<table border="2" style="text-align:center;margin-left:auto;margin-right:auto;">
					<tr bgcolor="#9acd32">
						<th>Title</th>
						<th>Barcode</th>
						<th>Price</th>
					</tr>
					<xsl:for-each select="base/books">
						<xsl:apply-templates select="."/>
					</xsl:for-each>
				</table>
				
				<h2 style="text-align:center">Other products</h2>
				<table border="2" style="text-align:center;margin-left:auto;margin-right:auto;">
					<tr bgcolor="#9acd32">
						<th>Name</th>
						<th>Barcode</th>
						<th>Price</th>
					</tr>
					<xsl:for-each select="base/other_products">
						<xsl:apply-templates select="."/>
					</xsl:for-each>
				</table>
				
				<h2 style="text-align:center">Need to supply, 5 or less</h2>
				<table border="2" style="text-align:center;margin-left:auto;margin-right:auto;">
					<tr bgcolor="#9acd32">
						<th>Barcode</th>
						<th>Amount</th>
					</tr>
					<xsl:for-each select="base/inventory">
						<xsl:apply-templates select=".">
						</xsl:apply-templates>
					</xsl:for-each>
				</table>
		</body>
	</html>
</xsl:template>

<xsl:template match="book">
	<tr>
		<td><font color="black"><xsl:value-of select="name"/></font></td>
		<td><font color="blue"><xsl:value-of select="@barcodeIdRef"/></font></td>
		<td><font color="black"><xsl:value-of select="price"/></font> zł</td>
	</tr>
</xsl:template>

<xsl:template match="product">
	<tr>
		<td><font color="black"><xsl:value-of select="name"/></font></td>
		<td><font color="red"><xsl:value-of select="@barcodeIdRef"/></font></td>
		<td><font color="black"><xsl:value-of select="price"/></font> zł</td>
	</tr>
</xsl:template>

<xsl:template match="prInv">
	<xsl:if test="amount &lt; 6">
	<tr>
			<td><font color="red"><xsl:value-of select="@barcodeId"/></font></td>
			<td><font color="black"><xsl:value-of select="amount"/></font></td>
	</tr>
	</xsl:if>
</xsl:template>

</xsl:stylesheet>





