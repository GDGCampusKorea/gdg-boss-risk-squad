interface SpaceProps {
  margin?: string;
  width?: string;
  height?: string;
  src: string;
  alt: string;
  borderRadius?: number;
}

export function Thumbnail({
  src,
  alt,
  margin = "0px",
  width = "32px",
  height = "32px",
  borderRadius,
}: SpaceProps) {
  return (
    <img src={src} alt={alt} style={{ margin, width, height, borderRadius }} />
  );
}
