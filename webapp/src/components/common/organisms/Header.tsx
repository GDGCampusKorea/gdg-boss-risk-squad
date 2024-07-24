import { Top0 } from "@styles/f"
import { Flex } from "../atoms/Flex"



interface HeaderProps{
    icon: "/back.png" | "/logo.png"
    title?: string
    bottomLine?: false | true
}

const Header = ({icon, title, bottomLine}: HeaderProps) => {
    return(
        <Top0 style={bottomLine ? {borderBottom: "2px solid #CECECE"}: {border: "none"}}>
            <Flex height="64px" justify="flex-start" direction="row">
                <Flex width="36px" height="36px" style={{margin: "8px"}}>
                    <img src={icon} alt="로고" />
                </Flex>
                <h1>{title}</h1>
            </Flex>
        </Top0>
    )
}

export default Header