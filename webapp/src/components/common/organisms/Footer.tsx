import { Bottom0 } from "@styles/f"
import { Flex } from "../atoms/Flex"
import { Text } from "../atoms/Text"
import { useState, useEffect } from "react";


type TextType = "글쓰기" | "홈" | "알바찾기";

interface FooterButtonProps{
    img: "/pen.png" | "/home.png" | "/people.png";
    text: TextType;
    location?: TextType | null;
    onClick: () => void
}

export const FooterButton = ({ img, text, location, onClick }: FooterButtonProps) => {
    return (
        <button style={{width: "100%", height: "100%", cursor: 'pointer', background: "none", border: "none"}} onClick={onClick}>
            <Flex gap={8}>
                <Flex style={{ 
                    backgroundColor: location === text ? "#FFDAD5" : "transparent", 
                    borderRadius: "16px",
                    width: "64px",
                    height: "32px"
                    }}>
                    <img src={img} alt={text} />
                </Flex>
                <Text weight={location === text ? "bold" : "normal"}>{text}</Text>
            </Flex>
        </button>
    );
  };



const Footer = ({ location }: Pick<FooterButtonProps, "location">) => {
    const [currentLocation, setCurrentLocation] = useState<TextType | null>(null);


    useEffect(() => {
        if(!location) return

        setCurrentLocation(location);
    }, [location]);

    const handleButtonClick = (newLocation: TextType) => {
        setCurrentLocation(newLocation);
    };

    return (
        <Bottom0 style={{ width: "100%" }}>
            <Flex height="80px" justify="space-between" direction="row">
                <FooterButton
                    img="/pen.png"
                    text="글쓰기"
                    location={currentLocation}
                    onClick={() => handleButtonClick("글쓰기")}
                />
                <FooterButton
                    img="/home.png"
                    text="홈"
                    location={currentLocation}
                    onClick={() => handleButtonClick("홈")}
                />
                <FooterButton
                    img="/people.png"
                    text="알바찾기"
                    location={currentLocation}
                    onClick={() => handleButtonClick("알바찾기")}
                />
            </Flex>
        </Bottom0>
    );
};

export default Footer