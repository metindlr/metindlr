<xsl:stylesheet version="1.0"
 xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

 <xsl:template match="node()|@*">
     <xsl:copy>
       <xsl:apply-templates select="node()|@*"/>
     </xsl:copy>
 </xsl:template>

<xsl:template match="//S_UNT/D_0074/text()[.='B2B_SEG_COUNTER'] | //S_SE/D_96/text()[.='B2B_SEG_COUNTER']">
  <xsl:value-of select="count(//*[starts-with(name(), 'S_')])"/>
 </xsl:template>
</xsl:stylesheet>
