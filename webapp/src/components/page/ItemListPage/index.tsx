import { useFlow } from "@/lib/stackflow";
import { Text } from "@components/common/atoms/Text";
import AsyncBoundary from "@components/template/AsyncBoundary";
import { AppScreen } from "@stackflow/plugin-basic-ui";

export const ItemListPage = () => {
  const { push } = useFlow();
  return (
    <AsyncBoundary>
      <AppScreen>
        <Text onClick={() => push("ItemUploadPage", {})}>상품 올리기</Text>
        <Text onClick={() => push("ItemDetailPage", {})}>세부 페이지</Text>
      </AppScreen>
    </AsyncBoundary>
  );
};
