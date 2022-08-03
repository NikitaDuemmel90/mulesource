package mule.guifactory;

import java.awt.Color;
import java.io.Serializable;

import javax.swing.BorderFactory;

import mule.guifactory.GUIFactory.Colour;
import mule.util.MuLEReferenceType;

public class GUIFactoryBorders {
	// BORDERS

	public static MuLEReferenceType<TitledBorder> createTitledBorder(Colour colour, int thickness, String title) {
		return new MuLEReferenceType<>(new TitledBorder(colour, thickness, title));
	}

	public static MuLEReferenceType<TitledBorder> createTitledBorder(String title, int thickness_top, int thickness_left,
			int thickness_bottom, int thickness_right) {
		return new MuLEReferenceType<>(new TitledBorder(title, thickness_top, thickness_left, thickness_bottom, thickness_right));
	}

	public static MuLEReferenceType<LineBorder> createLineBorder(Colour colour) {
		return new MuLEReferenceType<>(new LineBorder(colour));
	}

	public static MuLEReferenceType<LineBorder> createLineBorder(Colour colour, int thickness) {
		return new MuLEReferenceType<>(new LineBorder(colour, thickness));
	}

	public static MuLEReferenceType<LineBorder> createLineBorder(Colour colour, int thickness, boolean rounded) {
		return new MuLEReferenceType<>(new LineBorder(colour, thickness, rounded));
	}

	public static MuLEReferenceType<LineBorder> createLineBorder(Colour colour, int thickness_top, int thickness_left,
			int thickness_bottom, int thickness_right) {
		return new MuLEReferenceType<>(new LineBorder(colour, thickness_top, thickness_left, thickness_bottom, thickness_right));
	}

	public static MuLEReferenceType<BevelBorder> createBevelBorder(BorderType borderType) {
		return new MuLEReferenceType<>(new BevelBorder(borderType));
	}

	public static MuLEReferenceType<BevelBorder> createBevelBorder(BorderType borderType, Colour highlight, Colour shadow) {
		return new MuLEReferenceType<>(new BevelBorder(borderType, highlight, shadow));
	}

	public static enum BorderType {
		RAISED, LOWERED
	}
	
	// BORDERS

	public static abstract class Border implements Serializable {
		public javax.swing.border.Border border;

		public abstract javax.swing.border.Border getBorder();
	}

	public static class BevelBorder extends Border {

		public BevelBorder(BorderType borderType) {
			switch (borderType) {
			case RAISED:
				border = BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED);
				break;
			case LOWERED:
				border = BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED);
				break;
			default:
				border = BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED);
				break;
			}
		}

		public BevelBorder(BorderType borderType, Colour highlight, Colour shadow) {
			switch (borderType) {
			case RAISED:
				border = BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED,
						new Color(highlight.r, highlight.g, highlight.b, highlight.a),
						new Color(shadow.r, shadow.g, shadow.b, shadow.a));
				break;
			case LOWERED:
				border = BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED,
						new Color(highlight.r, highlight.g, highlight.b, highlight.a),
						new Color(shadow.r, shadow.g, shadow.b, shadow.a));
				break;
			default:
				border = BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED,
						new Color(highlight.r, highlight.g, highlight.b, highlight.a),
						new Color(shadow.r, shadow.g, shadow.b, shadow.a));
				break;
			}
		}

		@Override
		public javax.swing.border.Border getBorder() {
			return border;
		}
	}

	public static class LineBorder extends Border {
		public LineBorder(Colour colour) {
			border = BorderFactory.createLineBorder(new Color(colour.r, colour.g, colour.b, colour.a));
		}

		public LineBorder(Colour colour, int thickness) {
			border = BorderFactory.createLineBorder(new Color(colour.r, colour.g, colour.b, colour.a), thickness);
		}

		public LineBorder(Colour colour, int thickness, boolean rounded) {
			border = BorderFactory.createLineBorder(new Color(colour.r, colour.g, colour.b, colour.a), thickness,
					rounded);
		}

		public LineBorder(Colour colour, int thickness_top, int thickness_left, int thickness_bottom,
				int thickness_right) {
			border = BorderFactory.createMatteBorder(thickness_top, thickness_left, thickness_bottom, thickness_right,
					new Color(colour.r, colour.g, colour.b, colour.a));
		}

		@Override
		public javax.swing.border.Border getBorder() {
			return border;
		}
	}

	public static class TitledBorder extends Border {

		public TitledBorder(Colour colour, int thickness, String title) {
			border = BorderFactory.createTitledBorder(
					BorderFactory.createLineBorder(new Color(colour.r, colour.g, colour.b, colour.a), thickness),
					title);
		}

		public TitledBorder(String title, int thickness_top, int thickness_left, int thickness_bottom,
				int thickness_right) {
			border = BorderFactory.createTitledBorder(
					BorderFactory.createEmptyBorder(thickness_top, thickness_left, thickness_bottom, thickness_right),
					title);
		}

		@Override
		public javax.swing.border.Border getBorder() {
			return border;
		}
	}



}
