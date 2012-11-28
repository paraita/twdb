<?xml version="1.0" encoding="ISO-8859-1" ?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

    <xsl:output method="html"/>

    <xsl:import href="templatehtml.xsl"/>

    <xsl:template match="countries">
        <ul>
        <xsl:apply-templates/>
        </ul>
    </xsl:template>

    <xsl:template match="country">
	<li><a href="./country/{@car_code}.html"><xsl:value-of select="current()"/></a></li>
    </xsl:template>

</xsl:stylesheet>