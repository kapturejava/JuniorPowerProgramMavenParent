package be.kapture.util.pdf;

import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

public class PDFUtils {

	public static final Font FOOTER_BOLD = new Font(FontFamily.HELVETICA, 8, Font.BOLD);
	public static final Font FOOTER = new Font(FontFamily.HELVETICA, 8, Font.NORMAL);
	public static final Font SMALL = new Font(FontFamily.HELVETICA, 7, Font.NORMAL);
	public static final Font SMALL_BOLD = new Font(FontFamily.HELVETICA, 7, Font.BOLD);
	public static final Font NORMAL = new Font(FontFamily.HELVETICA, 10, Font.NORMAL);
	public static final Font NORMAL_BIG = new Font(FontFamily.HELVETICA, 13, Font.NORMAL);
	public static final Font BOLD = new Font(FontFamily.HELVETICA, 10, Font.BOLD);
	public static final Font BOLD_BIG = new Font(FontFamily.HELVETICA, 13, Font.BOLD);
	public static final Font TITLE = new Font(FontFamily.HELVETICA, 16, Font.BOLD);
	public static final Font SUBTITLE = new Font(FontFamily.HELVETICA, 12, Font.BOLD);
	public static final Font SUBTITLE_BIG = new Font(FontFamily.HELVETICA, 24, Font.BOLD);
	public static final Font SUBSUBTITLE = new Font(FontFamily.HELVETICA, 10, Font.BOLD);
	public static final Font ITALIC = new Font(FontFamily.HELVETICA, 10, Font.ITALIC);
	public static final Font BOLDITALIC = new Font(FontFamily.HELVETICA, 10, Font.BOLDITALIC);

	public static final String COMPLETE_ROW = "0";

	private static Phrase getTitlePhrase(String text) {
		return new Phrase(text, TITLE);
	}

	private static Phrase getSubTitlePhrase(String text) {
		return new Phrase(text, SUBTITLE);
	}

	private static Phrase getSubSubTitlePhrase(String text) {
		return new Phrase(text, SUBSUBTITLE);
	}

	public static Phrase getBoldPhrase(String text) {
		return new Phrase(text, BOLD);
	}

	public static Phrase getBigBoldPhrase(String text) {
		return new Phrase(text, BOLD_BIG);
	}

	private static Phrase getItalicPhrase(String text) {
		return new Phrase(text, ITALIC);
	}

	public static Phrase getPhrase(String text) {
		return new Phrase(text, NORMAL);
	}

	public static Phrase getBigPhrase(String text) {
		return new Phrase(text, NORMAL_BIG);
	}

	public static Phrase getSmallPhrase(String text) {
		return new Phrase(text, SMALL);
	}

	private static Phrase getFooterPhrase(String text) {
		return new Phrase(text, FOOTER);
	}

	private static Phrase getSmallBoldPhrase(String text) {
		return new Phrase(text, SMALL_BOLD);
	}

	public static Phrase getPhrase(String text, int fontSize) {
		return new Phrase(text, new Font(FontFamily.HELVETICA, fontSize, Font.NORMAL));
	}

	public static PdfPCell getCell(String text) {
		PdfPCell cell = new PdfPCell(getPhrase(text));
		cell.setBorder(PdfPCell.NO_BORDER);
		return cell;
	}

	public static PdfPCell getBigCell(String text) {
		PdfPCell cell = new PdfPCell(getBigPhrase(text));
		cell.setBorder(PdfPCell.NO_BORDER);
		return cell;
	}

	public static PdfPCell getCell(String text, boolean border) {
		return getCell(text, Element.ALIGN_LEFT, 1, 1, border);
	}

	public static PdfPCell getCell(String text, int colspan, int rowspan) {
		return getCell(text, Element.ALIGN_LEFT, colspan, rowspan, false);
	}

	public static PdfPCell getCell(String text, int horizontalAlignment) {
		return getCell(text, horizontalAlignment, 1, 1, false);
	}

	public static PdfPCell getCell(String text, int horizontalAlignment, boolean border) {
		return getCell(text, horizontalAlignment, 1, 1, border);
	}

	public static PdfPCell getCell(String text, int colspan, int rowspan, boolean border) {
		return getCell(text, Element.ALIGN_LEFT, colspan, rowspan, border);
	}

	public static PdfPCell getCell(String text, int horizontalAlignment, int colspan, int rowspan, boolean border) {
		PdfPCell cell = new PdfPCell(getPhrase(text));
		if (!border) {
			cell.setBorder(PdfPCell.NO_BORDER);
		}
		cell.setHorizontalAlignment(horizontalAlignment);
		cell.setPadding(1);
		cell.setColspan(colspan);
		cell.setRowspan(rowspan);
		return cell;
	}

	public static PdfPCell getSmallCell(String text, boolean border) {
		return getSmallCell(text, Element.ALIGN_LEFT, 1, 1, border);
	}

	public static PdfPCell getSmallCell(String text, int colspan, int rowspan) {
		return getSmallCell(text, Element.ALIGN_LEFT, colspan, rowspan, false);
	}

	public static PdfPCell getSmallCell(String text, int horizontalAlignment) {
		return getSmallCell(text, horizontalAlignment, 1, 1, false);
	}

	public static PdfPCell getSmallCell(String text, int horizontalAlignment, boolean border) {
		return getSmallCell(text, horizontalAlignment, 1, 1, border);
	}

	public static PdfPCell getSmallCell(String text, int colspan, int rowspan, boolean border) {
		return getSmallCell(text, Element.ALIGN_LEFT, colspan, rowspan, border);
	}

	public static PdfPCell getSmallCell(String text, int horizontalAlignment, int colspan, int rowspan,
			boolean border) {
		PdfPCell cell = new PdfPCell(getSmallPhrase(text));
		if (!border) {
			cell.setBorder(PdfPCell.NO_BORDER);
		}
		cell.setHorizontalAlignment(horizontalAlignment);
		cell.setPadding(1);
		cell.setColspan(colspan);
		cell.setRowspan(rowspan);
		return cell;
	}

	public static PdfPCell getTableDetailCell(String text) {
		PdfPCell cell = new PdfPCell(getPhrase(text));
		cell.setBorder(PdfPCell.LEFT | PdfPCell.RIGHT | PdfPCell.BOTTOM | PdfPCell.TOP);
		cell.setPaddingLeft(5);
		return cell;
	}

	public static PdfPCell getTableDetailCell(String text, int borders) {
		PdfPCell cell = new PdfPCell(getPhrase(text));
		cell.setBorder(borders);
		cell.setPaddingLeft(5);
		return cell;
	}

	public static PdfPCell getTitleCell(String text) {
		PdfPCell cell = new PdfPCell(getTitlePhrase(text));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorder(PdfPCell.NO_BORDER);
		return cell;
	}

	public static PdfPCell getSubTitleCell(String text) {
		PdfPCell cell = new PdfPCell(getSubTitlePhrase(text));
		cell.setPaddingLeft(10f);
		cell.setBorder(1);
		cell.setPaddingBottom(5f);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorder(PdfPCell.BOX);
		return cell;
	}

	public static PdfPCell getSubContentCell(String text) {
		PdfPCell cell = new PdfPCell(getPhrase(text));
		cell.setPaddingLeft(30f);

		cell.setBorder(PdfPCell.NO_BORDER);
		return cell;
	}

	public static PdfPCell getSubSubTitleCell(String text) {
		PdfPCell cell = new PdfPCell(getSubSubTitlePhrase(text));
		cell.setPaddingLeft(20f);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorder(PdfPCell.NO_BORDER);
		return cell;
	}

	public static PdfPCell getSubSubContentCell(String text) {
		PdfPCell cell = new PdfPCell(getPhrase(text));
		cell.setPaddingLeft(40f);
		cell.setBorder(PdfPCell.NO_BORDER);
		return cell;
	}

	public static PdfPCell getBoldCell(String text) {
		PdfPCell cell = new PdfPCell(getBoldPhrase(text));
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setPadding(1);
		return cell;
	}

	public static PdfPCell getBigBoldCell(String text) {
		PdfPCell cell = new PdfPCell(getBigBoldPhrase(text));
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setPadding(1);
		return cell;
	}

	public static PdfPCell getBoldCell(String text, int horizontalAlignment) {
		PdfPCell cell = new PdfPCell(getBoldPhrase(text));
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setHorizontalAlignment(horizontalAlignment);
		cell.setPadding(1);
		return cell;
	}

	public static PdfPCell getItalicCell(String text) {
		PdfPCell cell = new PdfPCell(getItalicPhrase(text));
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setPadding(1);
		return cell;
	}

	public static PdfPCell getSmallCell(String text) {
		PdfPCell cell = new PdfPCell(getSmallPhrase(text));
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setPadding(1);
		return cell;
	}

	public static PdfPCell getCustomSizeCell(String text, int fontSize) {
		PdfPCell cell = new PdfPCell(getPhrase(text, fontSize));
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setPadding(1);
		return cell;
	}

	public static PdfPCell getFooterCell(String text) {
		PdfPCell cell = new PdfPCell(getFooterPhrase(text));
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setPadding(1);
		return cell;
	}

	public static PdfPCell getSmallBoldCell(String text) {
		PdfPCell cell = new PdfPCell(getSmallBoldPhrase(text));
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setPadding(1);
		return cell;
	}

	public static PdfPCell getSmallBoldCell(String text, boolean border) {
		PdfPCell cell = new PdfPCell(getSmallBoldPhrase(text));
		if (!border) {
			cell.setBorder(PdfPCell.NO_BORDER);
		}
		cell.setPadding(1);
		return cell;
	}

	public static PdfPCell getBoldBorderdCell(String text) {
		return getBoldBorderdCell(text, Element.ALIGN_LEFT);
	}

	public static PdfPCell getBoldBorderdCell(String text, int horizontalAlignment) {
		PdfPCell cell = new PdfPCell(getBoldPhrase(text));
		cell.setHorizontalAlignment(horizontalAlignment);
		cell.setPaddingLeft(5);
		return cell;
	}

	public static PdfPTable getPdfPTable(float... relativeWidths) {
		PdfPTable t = new PdfPTable(relativeWidths);
		t.setWidthPercentage(100);
		return t;
	}

	public static void completeRow(PdfPTable table, int border) {
		PdfPCell defaultCell = table.getDefaultCell();
		defaultCell.setBorder(border);
		table.completeRow();
	}

	public static void addUnderlinedRow(PdfPTable table) {
		addUnderlinedRow(table, PdfPCell.BOTTOM);
	}

	/**
	 * The border is specified as an integer bitwise combination of the
	 * constants: LEFT, RIGHT, TOP, BOTTOM.
	 *
	 * @param table
	 * @param border
	 */
	public static void addUnderlinedRow(PdfPTable table, int border) {
		PdfPCell cell = new PdfPCell(getPhrase("\u00a0"));
		cell.setBorder(border);
		cell.setColspan(table.getNumberOfColumns());
		table.addCell(cell);
		table.completeRow();
	}

	/**
	 * The default border is PdfPCell.BOTTOM
	 *
	 * @param table
	 * @param fontSize
	 */
	public static void addUnderlinedRowCustomSize(PdfPTable table, int fontSize) {
		addUnderlinedRowCustomSize(table, PdfPCell.BOTTOM, fontSize);
	}

	/**
	 * The border is specified as an integer bitwise combination of the
	 * constants: LEFT, RIGHT, TOP, BOTTOM.
	 *
	 * @param table
	 * @param border
	 * @param fontSize
	 */
	public static void addUnderlinedRowCustomSize(PdfPTable table, int border, int fontSize) {
		PdfPCell cell = new PdfPCell(getCustomSizeCell("\u00a0", fontSize));
		cell.setBorder(border);
		cell.setColspan(table.getNumberOfColumns());
		table.addCell(cell);
		table.completeRow();
	}

	/**
	 *
	 * Essentially iText assumes for every 72 pixels that 1 inch of printed
	 * space will be used. So by default, a 200x200 pixel image placed by iText
	 * should print out at about 2 3/4. If you call scaleAbsolute(100,100) it
	 * will cram those 200 pixels into 100 user units giving you an effective
	 * DPI of 144 and print at about 1 3/8.
	 *
	 * @see <a href=
	 *      "http://stackoverflow.com/questions/8239380/image-quality-using-itext">
	 *      iText images</a>
	 *
	 * @param img
	 * @param horizontalAlignment
	 * @param width
	 * @param height
	 * @return
	 */
	public static PdfPCell getCellWithImage(Image img, int horizontalAlignment, float width, float height) {
		return getCellWithImage(img, horizontalAlignment, Element.ALIGN_MIDDLE, width, height);
	}

	public static PdfPCell getCellWithImage(Image img, int horizontalAlignment, int verticalAlignment, float width,
			float height) {
		PdfPCell cell = new PdfPCell();
		cell.setHorizontalAlignment(horizontalAlignment);
		cell.setVerticalAlignment(verticalAlignment);
		if (img != null) {
			switch (horizontalAlignment) {
			case Element.ALIGN_MIDDLE:
				img.setAlignment(Image.ALIGN_LEFT | Image.ALIGN_MIDDLE);
				break;
			case Element.ALIGN_CENTER:
				img.setAlignment(Image.ALIGN_CENTER | Image.ALIGN_MIDDLE);
				break;
			case Element.ALIGN_RIGHT:
				img.setAlignment(Image.ALIGN_RIGHT | Image.ALIGN_MIDDLE);
				break;
			}
			if (width > 0 && height > 0) {
				img.scaleAbsolute(width, height);
			}
			cell.addElement(img);
		} else {
			cell = new PdfPCell(getPhrase("\u00a0"));
		}
		cell.setBorder(PdfPCell.NO_BORDER);
		return cell;
	}

}
