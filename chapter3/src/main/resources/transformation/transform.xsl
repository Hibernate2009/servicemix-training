<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:bss="http://bssys.com/training">
	<xsl:template match="/">
		<bss:process>
			<xsl:copy-of select="/bss:item/*"/>
		</bss:process>
	</xsl:template>
</xsl:stylesheet>